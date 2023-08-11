package com.jrektabasa.superhero.data.remote.data_source.auth

import com.jrektabasa.superhero.presentation.state.SignInUiState

interface AuthRemoteDataSource {

    suspend fun signInWithGoogle(idToken: String): SignInUiState

}