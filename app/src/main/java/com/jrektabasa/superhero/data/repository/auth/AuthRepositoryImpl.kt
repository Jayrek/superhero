package com.jrektabasa.superhero.data.repository.auth

import android.content.Intent
import android.content.IntentSender
import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.data.model.response.UserResponse
import com.jrektabasa.superhero.data.remote.data_source.auth.AuthRemoteDataSource
import com.jrektabasa.superhero.domain.repository.auth.AuthRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val dataSource: AuthRemoteDataSource
) : AuthRepository {
    override suspend fun signInWithGoogle(): Result<IntentSender?> {
        val response = when (val res = dataSource.signInWithGoogle()) {
            is Result.Success -> res.data
            is Result.Error -> throw Exception()
        }
        return Result.Success(response)
    }

    override suspend fun signInWithIntent(intent: Intent): Result<UserResponse> {
        val response = when (val res = dataSource.signInWithIntent(intent)) {
            is Result.Success -> res.data
            is Result.Error -> throw Exception()
        }
        return Result.Success(response)
    }

    override suspend fun signOut(): Result<Unit> {
        val response = when (val res = dataSource.signOut()) {
            is Result.Success -> res.data
            is Result.Error -> throw Exception()
        }
        return Result.Success(response)
    }
}