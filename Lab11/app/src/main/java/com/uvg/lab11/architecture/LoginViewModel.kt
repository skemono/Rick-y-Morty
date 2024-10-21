package com.uvg.lab11.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.uvg.lab11.data.DataStorePrefs
import com.uvg.lab11.room.data.localdb.dao.CharacterDao
import com.uvg.lab11.room.data.localdb.dao.LocationDao
import com.uvg.lab11.room.data.localdb.di.Dependencies
import com.uvg.lab11.room.data.localdb.entity.toCharacter
import com.uvg.lab11.room.data.localdb.entity.toLocation
import com.uvg.lab11.util.Character
import com.uvg.lab11.util.Location
import dataStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class LoginViewModel(
    private val characterDao: CharacterDao,
    private val locationDao: LocationDao,
    private val dataStoreUserPrefs: DataStorePrefs
) : ViewModel() {

    private val _loginState = MutableStateFlow<LoginState>(LoginState.Initial)
    val loginState: StateFlow<LoginState> = _loginState.asStateFlow()

    var characters: StateFlow<List<Character>> = characterDao.getAllCharacters()
        .map { entities -> entities.map { it.toCharacter() } }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    var locations: StateFlow<List<Location>> = locationDao.getAllLocations()
        .map { entities -> entities.map { it.toLocation() } }.stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    private val _username = MutableStateFlow("")
    val username = _username.asStateFlow()

    init {
        checkLoginStatus()
    }

    private fun checkLoginStatus() {
        viewModelScope.launch {
            dataStoreUserPrefs.getUsername().collect { username ->
                if (!username.isNullOrBlank()) {
                    _loginState.value = LoginState.Success(username)
                } else {
                    _loginState.value = LoginState.LoggedOut
                }
            }
        }
    }

    fun updateUsername(name: String) {
        _username.value = name
    }

    fun login() {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            try {
                refreshCharacters()
                refreshLocations()
                dataStoreUserPrefs.setUsername(_username.value)
                _loginState.value = LoginState.Success(_username.value)
            } catch (e: Exception) {
                _loginState.value = LoginState.Error("Error al sincronizar: ${e.message}")
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            dataStoreUserPrefs.clearUsername()
            _loginState.value = LoginState.LoggedOut
        }
    }

    private suspend fun refreshCharacters() {
        characters = characterDao.getAllCharacters()
            .map { entities -> entities.map { it.toCharacter() } }.stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                emptyList()
            )
    }

    private suspend fun refreshLocations() {
        locations = locationDao.getAllLocations()
            .map { entities -> entities.map { it.toLocation() } }.stateIn(
                viewModelScope,
                SharingStarted.WhileSubscribed(5000),
                emptyList()
            )
    }

    sealed class LoginState {
        object Initial : LoginState()
        object Loading : LoginState()
        object LoggedOut : LoginState()
        data class Success(val username: String) : LoginState()
        data class Error(val message: String) : LoginState()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = checkNotNull(this[APPLICATION_KEY])
                val db = Dependencies.provideDatabase(application)
                val dataStore = Dependencies.provideDatabase(application)
                LoginViewModel(
                    characterDao = db.characterDao(),
                    locationDao = db.locationDao(),
                    dataStoreUserPrefs = DataStorePrefs(application.dataStore)
                )
            }
        }
    }
}