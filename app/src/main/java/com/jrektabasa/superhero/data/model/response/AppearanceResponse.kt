package com.jrektabasa.superhero.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppearanceResponse(
    @SerialName("eye-color") val eyeColor: String,
    val gender: String,
    @SerialName("hair-color") val hairColor: String,
    val height: List<String>,
    val race: String,
    val weight: List<String>,
)