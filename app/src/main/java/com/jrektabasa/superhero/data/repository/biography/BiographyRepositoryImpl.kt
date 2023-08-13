package com.jrektabasa.superhero.data.repository.biography

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

    override suspend fun getHeroBiography(id: String): Biography? {
        val heroBiography = dataSource.getHeroBiography(id)
        return heroBiography?.let { mapper.mapToDomain(it) }
    }
}