package com.jrektabasa.superhero.data.remote.data_source.biography

import com.jrektabasa.superhero.data.model.BiographyResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.*
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BiographyRemoteDataSourceImpl @Inject constructor(
    private val client: HttpClient
) : BiographyRemoteDataSource {

    // TODO move the base url and the access-token the build config for security
    override suspend fun getHeroBiography(id: String): BiographyResponse {
        try {
            val response: BiographyResponse =
                client.get {
                    url(
                        "https://www.superheroapi.com/api.php/10217999359720721/$id/biography",
                    )
                }.body()
            return response
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }
}