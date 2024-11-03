package com.uvg.lab12.ktor.data.network

import com.uvg.lab12.ktor.data.network.dto.CharacterDto
import com.uvg.lab12.ktor.data.network.dto.CharacterListDto
import com.uvg.lab12.ktor.data.network.dto.LocationDto
import com.uvg.lab12.ktor.data.network.dto.LocationListDto
import com.uvg.lab12.ktor.data.network.util.safeCall
import com.uvg.lab12.ktor.domain.network.util.NetworkError
import com.uvg.lab12.ktor.domain.network.util.Result
import com.uvg.lab12.ktor.domain.network.RickYMortyApi
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class KtorRickYMortyApi(
    private val httpClient: HttpClient
): RickYMortyApi {
    override suspend fun getAllCharacters(): Result<CharacterListDto, NetworkError> {
        return safeCall<CharacterListDto> {
            httpClient.get(
                "https://rickandmortyapi.com/api/character"
            )
        }
    }

    override suspend fun getCharacter(id: Int): Result<CharacterDto, NetworkError> {
        return safeCall<CharacterDto> {
            httpClient.get(
                "https://rickandmortyapi.com/api/character/{id}"
            )
        }
    }

    override suspend fun getAllLocations(): Result<LocationListDto, NetworkError> {
        return safeCall<LocationListDto> {
            httpClient.get(
                "https://rickandmortyapi.com/api/location"
            )
        }
    }

    override suspend fun getLocation(id: Int): Result<LocationDto, NetworkError> {
        return safeCall<LocationDto> {
            httpClient.get(
                "https://rickandmortyapi.com/api/location/{id}"
            )
        }
    }
}