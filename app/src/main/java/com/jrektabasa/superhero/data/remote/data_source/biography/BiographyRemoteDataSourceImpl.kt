package com.jrektabasa.superhero.data.remote.data_source.biography

import com.jrektabasa.superhero.BuildConfig
import com.jrektabasa.superhero.data.model.response.BiographyResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.*
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton
import com.jrektabasa.superhero.data.common.Result

@Singleton
class BiographyRemoteDataSourceImpl @Inject constructor(
    private val client: HttpClient
) : BiographyRemoteDataSource {

    override suspend fun getHeroBiography(id: String): Result<BiographyResponse> {
        return try {
            val response: BiographyResponse = client.get {
                url(
                    "${BuildConfig.BASE_URL}/" + BuildConfig.ACCESS_TOKEN + "/$id" + "/biography"
                )
            }.body()
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }
}