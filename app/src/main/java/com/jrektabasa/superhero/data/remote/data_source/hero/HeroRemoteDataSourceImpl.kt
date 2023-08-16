package com.jrektabasa.superhero.data.remote.data_source.hero

import com.google.firebase.firestore.FirebaseFirestore
import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.data.model.response.HeroResponse
import com.jrektabasa.superhero.util.firebase.FirebaseCollections
import com.jrektabasa.superhero.util.firebase.FirebaseFields
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeroRemoteDataSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore
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
}

