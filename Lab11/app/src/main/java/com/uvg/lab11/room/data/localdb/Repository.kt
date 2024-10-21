package com.uvg.lab11.room.data.localdb


import LocationDb
import com.uvg.lab11.room.data.localdb.dao.LocationDao
import com.uvg.lab11.room.data.localdb.dao.CharacterDao
import com.uvg.lab11.room.data.localdb.entity.toEntity
import com.uvg.lab11.room.data.localdb.entity.toCharacter
import com.uvg.lab11.room.data.localdb.entity.toLocation
import com.uvg.lab11.util.Character
import com.uvg.lab11.util.CharacterDb
import com.uvg.lab11.util.Location
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class Repository(
    private val characterDao: CharacterDao,
    private val locationDao: LocationDao,
    private val charactersDb: CharacterDb,
    private val locationsDb: LocationDb
) {
    val characters: Flow<List<Character>> = characterDao.getAllCharacters().map { entities ->
        entities.map { it.toCharacter() }
    }

    val locations: Flow<List<Location>> = locationDao.getAllLocations().map { entities ->
        entities.map { it.toLocation() }
    }

    suspend fun refreshCharacters() {
        val characters = charactersDb.getAllCharacters()
        characterDao.deleteAllCharacters()
        characterDao.insertCharacters(characters.map { it.toEntity() })
    }

    suspend fun refreshLocations() {
        val locations = locationsDb.getAllLocations()
        locationDao.deleteAllLocations()
        locationDao.insertLocations(locations.map { it.toEntity() })
    }

    suspend fun getCharacterById(id: Int): Character? {
        return characterDao.getCharacterById(id)?.toCharacter()
    }

    suspend fun getLocationById(id: Int): Location? {
        return locationDao.getLocationById(id)?.toLocation()
    }
}