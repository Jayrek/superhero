package com.jrektabasa.superhero.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class WorkResponse(
    val base: String,
    val occupation: String
)