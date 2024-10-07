package com.uvg.lab10.architecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import com.uvg.lab10.util.Location
import LocationDb

class LocationListViewModel(
    private val locationDb: LocationDb
) : ViewModel() {

    private val _state = MutableStateFlow(LocationListScreenState())
    val state = _state.asStateFlow()

    init {
        loadLocations()
    }

    private fun loadLocations() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            try {
                // Artificial 4-second delay
                delay(4000)
                val locations = locationDb.getAllLocations()
                _state.update { it.copy(locations = locations, isLoading = false) }
            } catch (e: Exception) {
                _state.update { it.copy(error = e.message ?: "Unknown error", isLoading = false) }
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return LocationListViewModel(LocationDb()) as T
            }
        }
    }
}

data class LocationListScreenState(
    val locations: List<Location> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)