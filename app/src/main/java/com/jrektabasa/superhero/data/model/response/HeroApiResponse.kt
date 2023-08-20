package com.jrektabasa.superhero.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HeroApiResponse(
    val appearance: AppearanceResponse,
    val biography: BiographyResponse,
    val connections: ConnectionsResponse,
    val id: String,
    val image: ImageResponse,
    val name: String,
    @SerialName("powerstats")
    val powerStats: PowerStatsResponse,
    val response: String,
    val work: WorkResponse
)