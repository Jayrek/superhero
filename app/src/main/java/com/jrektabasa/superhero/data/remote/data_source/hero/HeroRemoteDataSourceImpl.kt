package com.jrektabasa.superhero.data.remote.data_source.hero

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.jrektabasa.superhero.data.model.HeroResponse
import com.jrektabasa.superhero.util.firebase.FirebaseCollections
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HeroRemoteDataSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : HeroRemoteDataSource {
    override suspend fun getHeroList(): List<HeroResponse> {
        try {
            Log.wtf("isRunning", "getHeroList")
            val response = firestore.collection(FirebaseCollections.HERO).get().await()
            Log.wtf("HeroResponse", "$response")
            val heroList = mutableListOf<HeroResponse>()

            for (document in response.documents) {
                val heroData = document.data
                val heroId = heroData?.get("hero_id").toString()
                val heroName = heroData?.get("name").toString()

                // Assuming User is a data class representing your user model
                val user = HeroResponse(heroId = heroId, name = heroName)
                heroList.add(user)
            }

            return heroList
        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }
}