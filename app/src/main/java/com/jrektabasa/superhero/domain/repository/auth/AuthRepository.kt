package com.jrektabasa.superhero.domain.repository.auth

import android.content.Intent
import android.content.IntentSender
import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.data.model.response.UserResponse

interface AuthRepository {

    suspend fun signInWithGoogle(): Result<IntentSender?>

    suspend fun signInWithIntent(intent: Intent): Result<UserResponse>

    suspend fun signOut(): Result<Unit>
}