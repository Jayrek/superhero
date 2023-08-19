package com.jrektabasa.superhero.data.remote.data_source.auth

import android.content.Intent
import android.content.IntentSender
import android.util.Log
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.identity.BeginSignInRequest.GoogleIdTokenRequestOptions
import com.google.android.gms.auth.api.identity.SignInClient
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.jrektabasa.superhero.BuildConfig
import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.data.model.response.UserResponse
import kotlinx.coroutines.tasks.await
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRemoteDataSourceImpl @Inject constructor(
    private val firebaseAuth: FirebaseAuth, private val oneTapClient: SignInClient
) : AuthRemoteDataSource {

    override suspend fun signInWithGoogle(): Result<IntentSender?> {
        return try {
            val result = oneTapClient.beginSignIn(buildSignInRequest()).await()
            Result.Success(result?.pendingIntent?.intentSender)
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }

    override suspend fun signInWithEmailAndPassword(
        email: String, password: String
    ): Result<AuthResult> {
        return try {
            val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Result.Success(result)
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }

    override suspend fun signInWithIntent(intent: Intent): Result<UserResponse> {
        val intentCredential = oneTapClient.getSignInCredentialFromIntent(intent)
        val idToken = intentCredential.googleIdToken
        val googleCredential = GoogleAuthProvider.getCredential(idToken, null)
        return try {
            val user = firebaseAuth.signInWithCredential(googleCredential).await().user
            Log.wtf("USER: ", user?.displayName.toString())
            Result.Success(
                UserResponse(
                    userId = user?.uid,
                    userName = user?.displayName,
                    userProfileUrl = user?.photoUrl.toString()
                )
            )

        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }


    private fun buildSignInRequest(): BeginSignInRequest {
        return BeginSignInRequest.Builder().setGoogleIdTokenRequestOptions(
            GoogleIdTokenRequestOptions.builder().setSupported(true)
                .setFilterByAuthorizedAccounts(false)
                .setServerClientId(BuildConfig.WEB_CLIENT_ID).build()
        ).setAutoSelectEnabled(true).build()
    }

    override suspend fun signOut(): Result<Unit> {
        return try {
            oneTapClient.signOut().await()
            firebaseAuth.signOut()
            Result.Success(Unit)
        } catch (e: Exception) {
            Result.Error(e.message.toString())
        }
    }
}