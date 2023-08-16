package com.jrektabasa.superhero.data.repository.hero

import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.data.remote.data_source.hero.HeroRemoteDataSource
import com.jrektabasa.superhero.domain.mapper.HeroMapper
import com.jrektabasa.superhero.domain.model.Hero
import com.jrektabasa.superhero.domain.repository.HeroRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeroRepositoryImpl @Inject constructor(
    private val dataSource: HeroRemoteDataSource,
    private val mapper: HeroMapper,
) : HeroRepository {
    override suspend fun getHeroList(): Result<List<Hero>> {
        val response = when (val res = dataSource.getHeroList()) {
            is Result.Success -> res.data
            is Result.Error -> throw Exception()
        }

        val heroList = mapper.mapToDomain(response)
        return Result.Success(heroList)
    }
}