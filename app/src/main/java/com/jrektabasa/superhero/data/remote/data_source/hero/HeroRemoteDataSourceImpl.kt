package com.jrektabasa.superhero.data.remote.data_source.hero

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.jrektabasa.superhero.BuildConfig
import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.data.model.response.HeroApiResponse
import com.jrektabasa.superhero.data.model.response.HeroResponse
import com.jrektabasa.superhero.util.firebase.FirebaseCollections
import com.jrektabasa.superhero.util.firebase.FirebaseFields
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeroRemoteDataSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val client: HttpClient,
) : HeroRemoteDataSource {
    override suspend fun getHeroList(): Result<List<HeroResponse>> {
        return try {
            val response = firestore.collection(FirebaseCollections.HERO)
                .orderBy(FirebaseFields.HERO_ID)
                .get().await()

            val heroList = response.documents.mapNotNull {
                it.toObject(HeroResponse::class.java)
            }

            Result.Success(heroList)
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }

    override suspend fun getHeroById(id: String): Result<HeroApiResponse> {
        return try {
            val response: HeroApiResponse = client.get {
                url(
                    "${BuildConfig.BASE_URL}/" + BuildConfig.ACCESS_TOKEN + "/$id"
                )
            }.body()
            Log.wtf("HERO_BY_ID: ", response.name)
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }
}

