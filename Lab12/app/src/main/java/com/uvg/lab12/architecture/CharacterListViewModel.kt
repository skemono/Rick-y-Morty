package com.uvg.lab12.architecture

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.uvg.lab12.ktor.data.network.dto.mapToCharacterModel
import com.uvg.lab12.ktor.domain.network.RickYMortyApi
import com.uvg.lab12.ktor.domain.network.util.map
import com.uvg.lab12.ktor.domain.network.util.onError
import com.uvg.lab12.ktor.domain.network.util.onSuccess
import com.uvg.lab12.room.data.localdb.dao.CharacterDao
import com.uvg.lab12.room.data.localdb.di.Dependencies
import com.uvg.lab12.room.data.localdb.entity.CharacterEntity
import com.uvg.lab12.room.data.localdb.entity.toCharacter
import com.uvg.lab12.room.data.localdb.entity.toEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import com.uvg.lab12.util.Character
import com.uvg.lab12.util.CharacterDb
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.uvg.lab12.ktor.data.network.KtorRickYMortyApi
import com.uvg.lab12.ktor.di.KtorDependencies
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.delay

data class CharacterListScreenState(
    val isLoading: Boolean = false,
    val error: String? = null
)

class CharacterListViewModel(
    private val rickYMortyApi: RickYMortyApi,
    private val characterDao: CharacterDao,
    private val characterDb: CharacterDb
) : ViewModel() {
    private val _state = MutableStateFlow(CharacterListScreenState())
    val state = _state.asStateFlow()
    val characters = characterDao.getAllCharacters()
        .map { entities -> entities.map { it.toCharacter() } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    init {
        getCharactersFromAPI()
    }
    fun getCharactersFromLocalDb(){
        viewModelScope.launch {
            val characters = characterDb.getAllCharacters()
            characterDao.deleteAllCharacters()
            characterDao.insertCharacters(characters.map { it.toEntity() })
        }
    }

    fun getCharactersFromAPI() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true) }
            rickYMortyApi
                .getAllCharacters()
                .map { response -> response.results.map { it.mapToCharacterModel() } }
                .onSuccess { characters ->
                    addCharacters(characters.map { it.toEntity() })
                    println("Characters obtenidos desde la API")
                }
                .onError { error ->
                    getCharactersFromLocalDb()
                    println(error)
                    println("Characters obtenidos localmente")
                }
            delay(4000)
            _state.update { it.copy(isLoading = false) }
        }
    }

    fun addCharacters(characters: List<CharacterEntity>) {
        viewModelScope.launch {
            characterDao.insertCharacters(characters)
        }
    }


    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = checkNotNull(this[APPLICATION_KEY])
                val db = Dependencies.provideDatabase(application)
                CharacterListViewModel(
                    rickYMortyApi = KtorRickYMortyApi(KtorDependencies.provideHttpClient()),
                    characterDao = db.characterDao(),
                    characterDb = CharacterDb()
                )
            }
        }
    }
}