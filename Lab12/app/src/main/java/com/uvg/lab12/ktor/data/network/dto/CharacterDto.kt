package com.uvg.lab12.ktor.data.network.dto

import com.uvg.lab12.util.Character
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDto(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String
)

fun CharacterDto.mapToCharacterModel(): Character {
    return Character(
        id = id,
        name = name,
        status = status,
        species = species,
        gender = gender,
        image = image
    )
}
