package com.jrektabasa.superhero.domain.repository.auth

import com.jrektabasa.superhero.presentation.state.SignInUiState

interface AuthRepository {

    suspend fun signInWithGoogle(idToken: String): SignInUiState

}