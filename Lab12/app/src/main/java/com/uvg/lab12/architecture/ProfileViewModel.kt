package com.uvg.lab12.architecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.uvg.lab12.data.DataStorePrefs
import com.uvg.lab12.room.data.localdb.di.Dependencies
import dataStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val dataStoreUserPrefs: DataStorePrefs
) : ViewModel() {

    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username.asStateFlow()

    init {
        loadUsername()
    }

    private fun loadUsername() {
        viewModelScope.launch {
            dataStoreUserPrefs.getUsername().collect { username ->
                _username.value = username ?: ""
            }
        }
    }

    fun logout() {
        viewModelScope.launch {
            dataStoreUserPrefs.clearUsername()
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = checkNotNull(this[APPLICATION_KEY])
                val dataStore = Dependencies.provideDatabase(application)
                ProfileViewModel(
                    dataStoreUserPrefs = DataStorePrefs(application.dataStore)
                )
            }
        }
    }
}