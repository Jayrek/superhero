package com.jrektabasa.superhero.domain.repository

import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.domain.model.Hero

interface HeroRepository {
    suspend fun getHeroList(): Result<List<Hero>>
}