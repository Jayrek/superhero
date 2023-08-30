package com.jrektabasa.superhero.data.remote.data_source.character

import android.util.Log
import com.jrektabasa.superhero.BuildConfig
import com.jrektabasa.superhero.common.extension.toMD5
import com.jrektabasa.superhero.data.model.response.Character
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRemoteDataSourceImpl @Inject constructor(
    private val client: HttpClient
) : CharacterRemoteDataSource {
    override suspend fun getCharacter(): Character {
        val timestamp = System.currentTimeMillis()
        val hash = "$timestamp${BuildConfig.PRIVATE_API_KEY}${BuildConfig.PUBLIC_API_KEY}".toMD5()
        try {
            val response: Character = client.get {
                url(
                    "${BuildConfig.BASE_MARVEL_URL}/characters?" +
                            "apikey=${BuildConfig.PUBLIC_API_KEY}&" +
                            "ts=$timestamp&hash=$hash&orderBy=-modified&limit=100",
                )
            }.body()
            return response
        } catch (e: Exception) {
            Log.wtf("e: ", e.toString())
            throw Exception(e.message)
        }
    }


}