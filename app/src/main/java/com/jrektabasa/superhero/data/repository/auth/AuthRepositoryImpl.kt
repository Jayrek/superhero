package com.jrektabasa.superhero.data.repository.auth

import com.jrektabasa.superhero.data.remote.data_source.auth.AuthRemoteDataSource
import com.jrektabasa.superhero.domain.repository.auth.AuthRepository
import com.jrektabasa.superhero.presentation.state.SignInUiState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor(
    private val dataSource: AuthRemoteDataSource
) :
    AuthRepository {

    override suspend fun signInWithGoogle(idToken: String
    ): SignInUiState {
      return dataSource.signInWithGoogle(idToken = idToken)
    }
}