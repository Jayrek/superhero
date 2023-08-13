package com.jrektabasa.superhero.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BiographyResponse(
    val id: String,
    val response: String,
    val name: String,
    @SerialName("full-name")
    val fullName: String,
    @SerialName("alter-egos")
    val alterEgos: String,
    val aliases: List<String>,
    @SerialName("place-of-birth")
    val placeOfBirth: String,
    @SerialName("first-appearance")
    val firstAppearance: String,
    val publisher: String,
    val alignment: String,
)

