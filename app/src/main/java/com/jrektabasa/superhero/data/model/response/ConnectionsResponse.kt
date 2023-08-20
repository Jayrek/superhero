package com.jrektabasa.superhero.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ConnectionsResponse(
    @SerialName("group-affiliation") val groupAffiliation: String,
    val relatives: String,
)