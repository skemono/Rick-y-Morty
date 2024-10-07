package com.uvg.lab10

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import com.uvg.lab10.architecture.CharacterListScreenState
import com.uvg.lab10.architecture.CharacterListViewModel
import com.uvg.lab10.util.Character

@Composable
fun CharacterListRoute(
    onCharacterClick: (Int) -> Unit,
    viewModel: CharacterListViewModel = viewModel(factory = CharacterListViewModel.Factory)
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    CharacterListScreen(
        state = state,
        onCharacterClick = onCharacterClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterListScreen(
    state: CharacterListScreenState,
    onCharacterClick: (Int) -> Unit
) {
    Column(Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "Characters") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )

        when {
            state.isLoading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator(modifier = Modifier.size(50.dp))
                        Spacer(modifier = Modifier.height(16.dp))
                        Text("Loading characters...", style = MaterialTheme.typography.bodyLarge)
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
            else -> {
                LazyColumn(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                        .fillMaxHeight(0.9F)
                ) {
                    items(state.characters) { char ->
                        CharacterRow(char = char, onClickChar = onCharacterClick)
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun CharacterRow(char: Character, onClickChar: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp)
            .clickable { onClickChar(char.id) }
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(char.image)
                .crossfade(true)
                .build(),
            contentDescription = char.name,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .clip(CircleShape)
                .size(50.dp)
        )
        Column(modifier = Modifier.padding(start = 10.dp)) {
            Text(text = char.name, style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 14.sp))
            Text(text = "${char.species} - ${char.status}")
        }
    }
}