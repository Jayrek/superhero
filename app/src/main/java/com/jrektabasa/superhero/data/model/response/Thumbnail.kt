package com.jrektabasa.superhero.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class Thumbnail(
    val path: String,
    val extension: String
)
