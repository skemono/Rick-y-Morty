package com.uvg.lab10

import LocationDb
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uvg.lab10.architecture.LocationDetailScreenState
import com.uvg.lab10.architecture.LocationDetailViewModel

@Composable
fun LocationDetailRoute(
    locationId: Int,
    onBack: () -> Unit,
    viewModel: LocationDetailViewModel = viewModel(factory = LocationDetailViewModel.Factory)
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(locationId) {
        viewModel.loadLocation(locationId)
    }

    LocationDetailScreen(state = state, onBack = onBack)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationDetailScreen(
    state: LocationDetailScreenState,
    onBack: () -> Unit
) {
    Column(Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "Location Details") },
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
                        Text("Loading location details...", style = MaterialTheme.typography.bodyLarge)
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
            state.location != null -> {
                val location = state.location
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Text(
                        text = location.name,
                        style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(top = 10.dp)
                    )
                    Spacer(modifier = Modifier.height(40.dp))

                    LocationDetailRow("ID:", location.id.toString())
                    LocationDetailRow("Type:", location.type)
                    LocationDetailRow("Dimension:", location.dimension)
                }
            }
        }
    }
}

@Composable
fun LocationDetailRow(label: String, value: String) {
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