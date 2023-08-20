package com.jrektabasa.superhero.domain.mapper

import com.jrektabasa.superhero.data.model.response.HeroApiResponse
import com.jrektabasa.superhero.domain.model.HeroApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeroApiMapper @Inject constructor() {

    fun mapToDomain(response: HeroApiResponse): HeroApi {
        return HeroApi(
            response.appearance,
            response.biography,
            response.connections,
            response.id,
            response.image,
            response.name,
            response.powerStats,
            response.response,
            response.work,
        )
    }
}