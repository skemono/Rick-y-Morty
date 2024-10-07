package com.uvg.lab10.util
import kotlinx.serialization.Serializable

data class Location(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String
)