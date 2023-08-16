package com.jrektabasa.superhero.domain.use_case.auth

import android.content.Intent
import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.data.model.response.UserResponse
import com.jrektabasa.superhero.domain.repository.auth.AuthRepository
import javax.inject.Inject

class SignInWithIntentUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    suspend fun execute(intent: Intent): Result<UserResponse> {
        return repository.signInWithIntent(intent)
    }
}