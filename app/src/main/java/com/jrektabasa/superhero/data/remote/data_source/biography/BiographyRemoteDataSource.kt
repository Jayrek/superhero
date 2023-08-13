package com.jrektabasa.superhero.data.remote.data_source.biography

import com.jrektabasa.superhero.data.model.response.BiographyResponse

interface BiographyRemoteDataSource {

    suspend fun getHeroBiography(id: String): BiographyResponse?

}