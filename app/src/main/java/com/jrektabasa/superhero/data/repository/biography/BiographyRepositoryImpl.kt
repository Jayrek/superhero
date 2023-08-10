package com.jrektabasa.superhero.data.repository.biography

import com.jrektabasa.superhero.data.model.BiographyResponse
import com.jrektabasa.superhero.data.remote.data_source.biography.BiographyRemoteDataSource
import com.jrektabasa.superhero.domain.repository.biography.BiographyRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BiographyRepositoryImpl @Inject constructor(
    private val dataSource: BiographyRemoteDataSource
) : BiographyRepository {

    override suspend fun getHeroBiography(id: String): BiographyResponse? {
        return dataSource.getHeroBiography(id)
    }
}