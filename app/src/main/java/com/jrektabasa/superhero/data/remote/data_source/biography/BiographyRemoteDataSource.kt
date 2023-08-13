package com.jrektabasa.superhero.data.remote.data_source.biography

import com.jrektabasa.superhero.data.model.response.BiographyResponse
import com.jrektabasa.superhero.data.common.Result

interface BiographyRemoteDataSource {

    suspend fun getHeroBiography(id: String): Result<BiographyResponse>

}