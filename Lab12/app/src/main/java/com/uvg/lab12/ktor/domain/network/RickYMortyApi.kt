package com.uvg.lab12.ktor.domain.network

import com.uvg.lab12.ktor.data.network.dto.CharacterDto
import com.uvg.lab12.ktor.data.network.dto.CharacterListDto
import com.uvg.lab12.ktor.data.network.dto.LocationDto
import com.uvg.lab12.ktor.data.network.dto.LocationListDto
import com.uvg.lab12.ktor.domain.network.util.NetworkError
import com.uvg.lab12.ktor.domain.network.util.Result

interface RickYMortyApi {
    suspend fun getAllCharacters(): Result<CharacterListDto, NetworkError>
    suspend fun getCharacter(id: Int): Result<CharacterDto, NetworkError>
    suspend fun getAllLocations(): Result<LocationListDto, NetworkError>
    suspend fun getLocation(id: Int): Result<LocationDto, NetworkError>
}