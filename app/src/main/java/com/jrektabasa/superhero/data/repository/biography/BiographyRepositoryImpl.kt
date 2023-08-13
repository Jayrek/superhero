package com.jrektabasa.superhero.data.repository.biography

import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.data.remote.data_source.biography.BiographyRemoteDataSource
import com.jrektabasa.superhero.domain.mapper.BiographyMapper
import com.jrektabasa.superhero.domain.model.Biography
import com.jrektabasa.superhero.domain.repository.biography.BiographyRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BiographyRepositoryImpl @Inject constructor(
    private val dataSource: BiographyRemoteDataSource,
    private val mapper: BiographyMapper,
) : BiographyRepository {

    override suspend fun getHeroBiography(id: String): Result<Biography> {
        val response = when (val res = dataSource.getHeroBiography(id)) {
            is Result.Success -> res.data
            is Result.Error -> throw Exception()
        }

        val biography = mapper.mapToDomain(response)
        return Result.Success(biography)
    }
}