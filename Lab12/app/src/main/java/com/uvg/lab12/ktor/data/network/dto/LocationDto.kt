package com.uvg.lab12.ktor.data.network.dto

import com.uvg.lab12.util.Location
import kotlinx.serialization.Serializable

@Serializable
data class LocationDto(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String
)

fun LocationDto.mapToLocationModel(): Location {
    return Location(
        id = id,
        name = name,
        type = type,
        dimension = dimension
    )
}
