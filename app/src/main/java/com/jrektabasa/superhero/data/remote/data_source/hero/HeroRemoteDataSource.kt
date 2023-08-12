package com.jrektabasa.superhero.data.remote.data_source.hero

import com.jrektabasa.superhero.data.model.HeroResponse

interface HeroRemoteDataSource {
    suspend fun getHeroList(): List<HeroResponse>
}