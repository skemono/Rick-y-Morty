package com.uvg.lab12.architecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.uvg.lab12.room.data.localdb.dao.CharacterDao
import com.uvg.lab12.room.data.localdb.di.Dependencies
import com.uvg.lab12.room.data.localdb.entity.toCharacter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import com.uvg.lab12.util.Character
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

data class CharacterDetailScreenState(
    val character: Character? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

class CharacterDetailViewModel(
    private val characterDao: CharacterDao
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterDetailScreenState())
    val state = _state.asStateFlow()

    fun getCharacter(id: Int) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            try {
                // Artificial 2-second delay
                delay(2000)
                val character = characterDao.getCharacterById(id)!!.toCharacter()
                _state.update { it.copy(character = character, isLoading = false) }
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
                CharacterDetailViewModel(
                    characterDao = db.characterDao()
                )
            }
        }
    }
}