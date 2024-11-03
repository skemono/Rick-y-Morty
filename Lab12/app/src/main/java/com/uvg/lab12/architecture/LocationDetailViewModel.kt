package com.uvg.lab12.architecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.uvg.lab12.room.data.localdb.dao.LocationDao
import com.uvg.lab12.room.data.localdb.di.Dependencies
import com.uvg.lab12.room.data.localdb.entity.toLocation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import com.uvg.lab12.util.Location
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

data class LocationDetailScreenState(
    val location: Location? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

class LocationDetailViewModel(
    private val locationDao: LocationDao
) : ViewModel() {

    private val _state = MutableStateFlow(LocationDetailScreenState())
    val state = _state.asStateFlow()

    fun getLocation(id: Int) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            try {
                // Artificial 2-second delay
                delay(2000)
                val location = locationDao.getLocationById(id)!!.toLocation()
                _state.update { it.copy(location = location, isLoading = false) }
            } catch (e: Exception) {
                _state.update { it.copy(error = e.message ?: "Unknown error", isLoading = false) }
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = checkNotNull(this[APPLICATION_KEY])
                val db = Dependencies.provideDatabase(application)
                LocationDetailViewModel(
                    locationDao = db.locationDao()
                )
            }
        }
    }
}