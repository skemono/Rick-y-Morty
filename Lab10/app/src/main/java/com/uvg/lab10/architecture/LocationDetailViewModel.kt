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

class LocationDetailViewModel(
    private val locationDb: LocationDb
) : ViewModel() {

    private val _state = MutableStateFlow(LocationDetailScreenState())
    val state = _state.asStateFlow()

    fun loadLocation(id: Int) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            try {
                // Artificial 2-second delay
                delay(2000)
                val location = locationDb.getLocationById(id)
                _state.update { it.copy(location = location, isLoading = false) }
            } catch (e: Exception) {
                _state.update { it.copy(error = e.message ?: "Unknown error", isLoading = false) }
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return LocationDetailViewModel(LocationDb()) as T
            }
        }
    }
}

data class LocationDetailScreenState(
    val location: Location? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)