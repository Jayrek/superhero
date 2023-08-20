package com.jrektabasa.superhero.domain.repository

import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.domain.model.Hero
import com.jrektabasa.superhero.domain.model.HeroApi

interface HeroRepository {
    suspend fun getHeroList(): Result<List<Hero>>

    suspend fun getHeroById(id: String): Result<HeroApi>
}