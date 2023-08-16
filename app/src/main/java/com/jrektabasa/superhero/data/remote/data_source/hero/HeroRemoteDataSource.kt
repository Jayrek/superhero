package com.jrektabasa.superhero.data.remote.data_source.hero

import com.jrektabasa.superhero.data.model.response.HeroResponse
import com.jrektabasa.superhero.data.common.Result

interface HeroRemoteDataSource {
    suspend fun getHeroList(): Result<List<HeroResponse>>
}