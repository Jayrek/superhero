package com.jrektabasa.superhero.domain.mapper

import com.jrektabasa.superhero.data.model.response.HeroResponse
import com.jrektabasa.superhero.domain.model.Hero
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeroMapper @Inject constructor() {

    private fun mapToDomain(response: HeroResponse): Hero {
        return Hero(
            response.hero_id,
            response.name,
            response.reaction_count,
            response.comment_count,
        )
    }

    fun mapToDomain(responseList: List<HeroResponse>): List<Hero> {
        return responseList.map { mapToDomain(it) }
    }
}