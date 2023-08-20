package com.jrektabasa.superhero.data.remote.data_source.hero

import com.jrektabasa.superhero.data.model.response.HeroResponse
import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.data.model.response.HeroApiResponse

interface HeroRemoteDataSource {
    suspend fun getHeroList(): Result<List<HeroResponse>>

    suspend fun getHeroById(id: String): Result<HeroApiResponse>
}