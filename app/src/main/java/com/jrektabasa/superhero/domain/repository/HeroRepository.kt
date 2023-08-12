package com.jrektabasa.superhero.domain.repository

import com.jrektabasa.superhero.data.model.HeroResponse

interface HeroRepository {
    suspend fun getHeroList(): List<HeroResponse>
}