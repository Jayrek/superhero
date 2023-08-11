package com.jrektabasa.superhero.data.remote.data_source.auth

import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.jrektabasa.superhero.R
import com.jrektabasa.superhero.presentation.state.SignInUiState
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRemoteDataSourceImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) :
    AuthRemoteDataSource {
    override suspend fun signInWithGoogle(idToken: String): SignInUiState {
        return try {
            val credential = GoogleAuthProvider.getCredential(idToken, null)
            val auth = firebaseAuth.signInWithCredential(credential).await()
            val user = auth.user

            SignInUiState(user= user, isSuccess = true)

        } catch (e: Exception) {
            SignInUiState(isSuccess = false, error = e.message ?: "Unknown error occurred!")
        }
    }
}