package com.jrektabasa.superhero.data.repository.hero

import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.data.remote.data_source.hero.HeroRemoteDataSource
import com.jrektabasa.superhero.domain.mapper.HeroApiMapper
import com.jrektabasa.superhero.domain.mapper.HeroMapper
import com.jrektabasa.superhero.domain.model.Hero
import com.jrektabasa.superhero.domain.model.HeroApi
import com.jrektabasa.superhero.domain.repository.HeroRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeroRepositoryImpl @Inject constructor(
    private val dataSource: HeroRemoteDataSource,
    private val mapper: HeroMapper,
    private val heroApiMapper: HeroApiMapper,
) : HeroRepository {
    override suspend fun getHeroList(): Result<List<Hero>> {
        return when (val res = dataSource.getHeroList()) {
            is Result.Success -> {
                val heroList = mapper.mapToDomain(res.data)
                Result.Success(heroList)
            }

            is Result.Error -> Result.Error(res.message)
        }

    }

    override suspend fun getHeroById(id: String): Result<HeroApi> {
        return when (val res = dataSource.getHeroById(id)) {
            is Result.Success -> {
                val hero = heroApiMapper.mapToDomain(res.data)
                Result.Success(hero)
            }

            is Result.Error -> Result.Error(res.message)
        }
    }
}