package com.jrektabasa.superhero.data.remote.data_source.biography

import com.jrektabasa.superhero.data.model.BiographyResponse

interface BiographyRemoteDataSource {

    suspend fun getHeroBiography(id: String): BiographyResponse?

}