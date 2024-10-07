package com.uvg.lab10

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.uvg.lab10.architecture.CharacterDetailScreenState
import com.uvg.lab10.architecture.CharacterDetailViewModel

@Composable
fun CharacterDetailRoute(
    characterId: Int,
    onBack: () -> Unit,
    viewModel: CharacterDetailViewModel = viewModel(factory = CharacterDetailViewModel.Factory)
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(characterId) {
        viewModel.loadCharacter(characterId)
    }

    CharacterDetailScreen(state = state, onBack = onBack)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailScreen(
    state: CharacterDetailScreenState,
    onBack: () -> Unit
) {
    Column(Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "Character Details") },
            navigationIcon = {
                IconButton(onClick = onBack) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )

        when {
            state.isLoading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator(modifier = Modifier.size(50.dp))
                        Spacer(modifier = Modifier.height(16.dp))
                        Text("Loading character details...", style = MaterialTheme.typography.bodyLarge)
                    }
                }
            }
            state.error != null -> {
                Text(
                    text = "Error: ${state.error}",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.padding(16.dp)
                )
            }
            state.character != null -> {
                val character = state.character
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(character.image)
                            .crossfade(true)
                            .build(),
                        contentDescription = character.name,
                        contentScale = ContentScale.FillWidth,
                        modifier = Modifier
                            .size(200.dp)
                            .clip(CircleShape)
                    )
                    Text(
                        text = character.name,
                        style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(top = 10.dp)
                    )
                    Spacer(modifier = Modifier.height(40.dp))

                    CharacterDetailRow("Species:", character.species)
                    CharacterDetailRow("Status:", character.status)
                    CharacterDetailRow("Gender:", character.gender)
                }
            }
        }
    }
}

@Composable
fun CharacterDetailRow(label: String, value: String) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp)
    ) {
        Text(text = label)
        Text(text = value)
    }
}