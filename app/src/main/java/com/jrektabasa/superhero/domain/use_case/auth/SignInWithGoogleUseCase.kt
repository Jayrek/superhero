package com.jrektabasa.superhero.domain.use_case.auth

import android.content.IntentSender
import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.domain.repository.auth.AuthRepository
import javax.inject.Inject

class SignInWithGoogleUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    suspend fun execute(): Result<IntentSender?> {
        return repository.signInWithGoogle()
    }

}