package com.jrektabasa.superhero

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.presentation.viewmodel.auth.AuthViewModel
import com.jrektabasa.superhero.presentation.viewmodel.biography.BiographyViewModel
import com.jrektabasa.superhero.presentation.viewmodel.hero.HeroViewModel
import com.jrektabasa.superhero.ui.theme.SuperheroTheme
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val biographyViewModel by viewModels<BiographyViewModel>()
    private val authViewModel by viewModels<AuthViewModel>()

//    private val heroViewModel by viewModels<HeroViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val heroViewModel by viewModels<HeroViewModel>()




            val signInUiState = authViewModel.signInUiState.collectAsState()

            val heroList = heroViewModel.users.collectAsState()

            val googleSignInLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.StartActivityForResult()
            ) {
                if (it.resultCode == RESULT_OK) {
                    val intent = it.data
                    handleGoogleSignInState(intent)
                }
            }

            SuperheroTheme {
                // A surface container using the 'background' color from the theme
                LaunchedEffect(true) {
                    biographyViewModel.getHeroBiography("312")
                }

                val biography = biographyViewModel.biography.collectAsState()

                when(biography.value){
                    is Result.Error -> TODO()
                    is Result.Success -> {
                        val biographyData = (biography.value as Result.Success).data

                        Column() {
                            Text(text = biographyData.name)
                            Text(biographyData.fullName)
                            Button(onClick = {

//                                startGoogleSignIn(googleSignInLauncher)
                            }) {
                                Text("Sign In with Google")
                            }
                        }
                        signInUiState.let { result ->
                            Log.wtf("login", "${result.value?.isSuccess}")
                            Log.wtf("loginError", "${result.value?.error}")
                        }
                    }
                    null -> {}
                }



            }
        }
    }

    private fun handleGoogleSignInState(data: Intent?) {
        try {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            val account = task.getResult(ApiException::class.java)
            val idToken = account?.idToken

            if (idToken != null) {
                authViewModel.signInWithGoogle(idToken = idToken)
            } else {
                Log.wtf("handleGoogleSignInState: ", "no idToken")
            }


        } catch (e: Exception) {
            throw Exception(e.message)
        }
    }

    private fun startGoogleSignIn(launcher: ActivityResultLauncher<Intent>) {
        val googleSignInOptions =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

        val googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)
        val signIntent = googleSignInClient.signInIntent
        launcher.launch(signIntent)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperheroTheme {
        Greeting("Android")
    }
}