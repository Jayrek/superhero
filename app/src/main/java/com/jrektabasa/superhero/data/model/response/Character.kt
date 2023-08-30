package com.jrektabasa.superhero.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class Character(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val etag: String,
    val status: String,
    val data: Data
)