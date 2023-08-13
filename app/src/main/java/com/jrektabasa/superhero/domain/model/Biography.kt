package com.jrektabasa.superhero.domain.model

data class Biography(
    val id: String,
    val response: String,
    val name: String,
    val fullName: String,
    val alterEgos: String,
    val aliases: List<String>,
    val placeOfBirth: String,
    val firstAppearance: String,
    val publisher: String,
    val alignment: String,
)
