package com.jrektabasa.superhero.data.remote.data_source.auth

import android.content.Intent
import android.content.IntentSender
import com.google.firebase.auth.AuthResult
import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.data.model.response.UserResponse

interface AuthRemoteDataSource {

    suspend fun signInWithGoogle(): Result<IntentSender?>
    suspend fun signInWithEmailAndPassword(email: String, password: String): Result<AuthResult>

    suspend fun signInWithIntent(intent: Intent): Result<UserResponse>

    suspend fun signOut(): Result<Unit>
}