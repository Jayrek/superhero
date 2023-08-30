package com.jrektabasa.superhero.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int,
    val results: List<Result>
)
