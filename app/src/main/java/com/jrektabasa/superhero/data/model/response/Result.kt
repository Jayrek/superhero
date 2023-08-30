package com.jrektabasa.superhero.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val id: Int,
    val name: String,
    val description: String,
    val modified: String,
    val thumbnail: Thumbnail,
    val resourceURI: String,
)
