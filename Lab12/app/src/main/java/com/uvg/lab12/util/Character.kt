package com.uvg.lab12.util

import kotlinx.serialization.Serializable


@Serializable
data class Character(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val gender: String,
    val image: String
)