package com.uvg.lab12.ktor.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class LocationListDto(
    val results: List<LocationDto>
)