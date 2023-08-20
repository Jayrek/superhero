package com.jrektabasa.superhero.data.repository.auth

import android.content.Intent
import android.content.IntentSender
import com.google.firebase.auth.AuthResult
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

    /*
    * sign in with google provider
    * */
    override suspend fun signInWithGoogle(): Result<IntentSender?> {
        return when (val res = dataSource.signInWithGoogle()) {
            is Result.Success -> Result.Success(res.data)
            is Result.Error -> Result.Error(res.message)
        }
    }

    /*
    * sign in with email and password provider
    * */
    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Result<AuthResult> {
        return when (val res = dataSource.signInWithEmailAndPassword(email, password)) {
            is Result.Success -> Result.Success(res.data)
            is Result.Error -> Result.Error(res.message)
        }
    }

    override suspend fun signInWithIntent(intent: Intent): Result<UserResponse> {
        return when (val res = dataSource.signInWithIntent(intent)) {
            is Result.Success -> Result.Success(res.data)
            is Result.Error -> Result.Error(res.message)
        }
    }

    override suspend fun signOut(): Result<Unit> {
        return when (val res = dataSource.signOut()) {
            is Result.Success -> Result.Success(res.data)
            is Result.Error -> Result.Error(res.message)
        }
    }
}