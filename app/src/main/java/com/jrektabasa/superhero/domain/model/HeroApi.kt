package com.jrektabasa.superhero.domain.model

import com.jrektabasa.superhero.data.model.response.*

data class HeroApi(
    val appearance: AppearanceResponse,
    val biography: BiographyResponse,
    val connections: ConnectionsResponse,
    val id: String,
    val image: ImageResponse,
    val name: String,
    val powerStats: PowerStatsResponse,
    val response: String,
    val work: WorkResponse
)
