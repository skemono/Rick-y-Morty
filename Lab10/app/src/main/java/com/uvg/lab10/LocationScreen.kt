package com.uvg.lab10

import com.uvg.lab10.util.Location
import LocationDb
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import com.uvg.lab10.ui.theme.Lab10Theme
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uvg.lab10.architecture.LocationListScreenState
import com.uvg.lab10.architecture.LocationListViewModel
import com.uvg.lab10.ui.theme.Lab10Theme

@Composable
fun LocationListRoute(
    onLocationClick: (Int) -> Unit,
    viewModel: LocationListViewModel = viewModel(factory = LocationListViewModel.Factory)
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    LocationListScreen(
        state = state,
        onLocationClick = onLocationClick
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationListScreen(
    state: LocationListScreenState,
    onLocationClick: (Int) -> Unit
) {
    Column(Modifier.fillMaxSize()) {
        TopAppBar(
            title = { Text(text = "Locations") },
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
                        Text("Loading locations...", style = MaterialTheme.typography.bodyLarge)
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
                    items(state.locations) { location ->
                        LocationRow(location = location, onClickLocation = onLocationClick)
                        Spacer(modifier = Modifier.height(20.dp))
                    }
                }
            }
        }
    }
}

@Composable
fun LocationRow(location: Location, onClickLocation: (Int) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp)
            .clickable { onClickLocation(location.id) }
    ) {
        Text(text = location.name, style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold))
        Spacer(modifier = Modifier.height(5.dp))
        Text(text = location.type, style = TextStyle(fontSize = 12.sp))
    }
}

@Composable
fun LocationScreenPreview() {
    Lab10Theme {
        LocationListRoute(
            onLocationClick = { /* Do nothing in preview */ }
        )
    }
}