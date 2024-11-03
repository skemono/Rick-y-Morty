package com.uvg.lab12.architecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.uvg.lab12.ktor.data.network.dto.mapToLocationModel
import com.uvg.lab12.ktor.domain.network.RickYMortyApi
import com.uvg.lab12.ktor.domain.network.util.map
import com.uvg.lab12.ktor.domain.network.util.onError
import com.uvg.lab12.ktor.domain.network.util.onSuccess
import com.uvg.lab12.room.data.localdb.dao.LocationDao
import com.uvg.lab12.room.data.localdb.di.Dependencies
import com.uvg.lab12.room.data.localdb.entity.LocationEntity
import com.uvg.lab12.room.data.localdb.entity.toLocation
import com.uvg.lab12.room.data.localdb.entity.toEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.uvg.lab12.util.Location
import com.uvg.lab12.util.LocationDb
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.uvg.lab12.ktor.data.network.KtorRickYMortyApi
import com.uvg.lab12.ktor.di.KtorDependencies
import com.uvg.lab12.room.data.localdb.entity.toCharacter
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update


data class LocationListScreenState(
    val isLoading: Boolean = false,
    val error: String? = null
)

class LocationListViewModel(
    private val rickYMortyApi: RickYMortyApi,
    private val locationDao: LocationDao,
    private val locationDb: LocationDb
) : ViewModel() {
    private val _state = MutableStateFlow(LocationListScreenState())
    val state = _state.asStateFlow()
    val locations = locationDao.getAllLocations()
        .map { entities -> entities.map { it.toLocation() } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    init {
        getLocationsFromAPI()
    }
    fun getLocationsFromLocalDb(){
        viewModelScope.launch {
            val locations = locationDb.getAllLocations()
            locationDao.deleteAllLocations()
            locationDao.insertLocations(locations.map { it.toEntity() })
        }
    }

    fun getLocationsFromAPI() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            rickYMortyApi
                .getAllLocations()
                .map { response -> response.results.map { it.mapToLocationModel() } }
                .onSuccess { locations ->
                    addLocations(locations.map { it.toEntity() })
                    println("Locations obtenidos desde la API")
                }
                .onError { error ->
                    getLocationsFromLocalDb()
                    println(error)
                    println("Locations obtenidos localmente")
                }
            delay(4000)
            _state.update { it.copy(isLoading = false) }
        }
    }


    fun addLocations(locations: List<LocationEntity>) {
        viewModelScope.launch {
            locationDao.insertLocations(locations)
        }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = checkNotNull(this[APPLICATION_KEY])
                val db = Dependencies.provideDatabase(application)
                LocationListViewModel(
                    rickYMortyApi = KtorRickYMortyApi(KtorDependencies.provideHttpClient()),
                    locationDao = db.locationDao(),
                    locationDb = LocationDb()
                )
            }
        }
    }
}