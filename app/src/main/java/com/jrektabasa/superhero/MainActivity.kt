package com.jrektabasa.superhero

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.presentation.screen.SignInScreen
import com.jrektabasa.superhero.presentation.viewmodel.auth.AuthViewModel
import com.jrektabasa.superhero.presentation.viewmodel.biography.BiographyViewModel
import com.jrektabasa.superhero.presentation.viewmodel.hero.HeroViewModel
import com.jrektabasa.superhero.ui.theme.SuperheroTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val biographyViewModel by viewModels<BiographyViewModel>()
    private val authViewModel by viewModels<AuthViewModel>()

//    private val heroViewModel by viewModels<HeroViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val heroViewModel by viewModels<HeroViewModel>()


            val signInIntent = authViewModel.intentSender.collectAsState()

            val heroList = heroViewModel.heroList.collectAsState()

            val googleSignInLauncher = rememberLauncherForActivityResult(
                contract = ActivityResultContracts.StartIntentSenderForResult(),
                onResult = { result ->
                    if (result.resultCode == RESULT_OK) {
                        lifecycleScope.launch {
                            authViewModel.signInWithIntent(result)

                        }
//                    val intent = it.data
//                    handleGoogleSignInState(intent)
                    }
                }
            )

            SuperheroTheme {
                SignInScreen()
                // A surface container using the 'background' color from the theme
//                LaunchedEffect(true) {
//                    biographyViewModel.getHeroBiography("312")
//                }
               /* when (signInIntent.value) {
                    is Result.Success -> {
                        val df = (signInIntent.value as Result.Success).data
                        googleSignInLauncher.launch(
                            IntentSenderRequest.Builder(
                                df ?: return@SuperheroTheme
                            ).build()
                        )
                    }

                    is Result.Error -> TODO()
                    null -> Text("signisdf")
                }

                Log.wtf("heroList: ", "${heroList.value}")
                when (heroList.value) {
                    is Result.Error -> TODO()
                    is Result.Success -> {
                        val heroes = (heroList.value as Result.Success).data

                        Column {
                            Button(onClick = {
                                lifecycleScope.launch {
                                    authViewModel.signInWithGoogle()
                                }

                            }) {
                                Text("Sign In with Google")
                            }
                            LazyColumn {
                                items(items = heroes) { hero ->
                                    Text(text = "id: ${hero.heroId} = ${hero.name}")
                                }
                            }
                        }

                    }

                    null -> Text("dfsfs")
                }*/

//                val biography = biographyViewModel.biography.collectAsState()
//
//                when(biography.value){
//                    is Result.Error -> TODO()
//                    is Result.Success -> {
//                        val biographyData = (biography.value as Result.Success).data
//
//                        Column() {
//                            Text(text = biographyData.name)
//                            Text(biographyData.fullName)
//                            Button(onClick = {
//
////                                startGoogleSignIn(googleSignInLauncher)
//                            }) {
//                                Text("Sign In with Google")
//                            }
//                        }
//                        signInUiState.let { result ->
//                            Log.wtf("login", "${result.value?.isSuccess}")
//                            Log.wtf("loginError", "${result.value?.error}")
//                        }
//                    }
//                    null -> {}
//                }


            }
        }
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