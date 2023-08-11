package com.jrektabasa.superhero.domain.use_case.auth

import com.jrektabasa.superhero.domain.repository.auth.AuthRepository
import com.jrektabasa.superhero.presentation.state.SignInUiState
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    suspend fun signInWithGoogle(idToken: String): SignInUiState {
        return repository.signInWithGoogle(
            idToken = idToken
        )
    }

}