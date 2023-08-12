package com.jrektabasa.superhero.data.repository.hero

import com.jrektabasa.superhero.data.model.HeroResponse
import com.jrektabasa.superhero.data.remote.data_source.hero.HeroRemoteDataSource
import com.jrektabasa.superhero.domain.repository.HeroRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeroRepositoryImpl @Inject constructor(
    private val dataSource: HeroRemoteDataSource
) : HeroRepository {
    override suspend fun getHeroList(): List<HeroResponse> {
        return dataSource.getHeroList()
    }
}