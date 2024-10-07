package com.uvg.lab10.architecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import com.uvg.lab10.util.Character
import com.uvg.lab10.util.CharacterDb

class CharacterListViewModel(
    private val characterDb: CharacterDb
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterListScreenState())
    val state = _state.asStateFlow()

    init {
        loadCharacters()
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            try {
                // Artificial 4-second delay
                delay(4000)
                val characters = characterDb.getAllCharacters()
                _state.update { it.copy(characters = characters, isLoading = false) }
            } catch (e: Exception) {
                _state.update { it.copy(error = e.message ?: "Unknown error", isLoading = false) }
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return CharacterListViewModel(CharacterDb()) as T
            }
        }
    }
}

data class CharacterListScreenState(
    val characters: List<Character> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)