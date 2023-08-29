package com.jrektabasa.superhero

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.jrektabasa.superhero.presentation.screen.DashBoardScreen
import com.jrektabasa.superhero.presentation.screen.HeroScreen
import com.jrektabasa.superhero.presentation.viewmodel.hero.HeroByIdViewModel
import com.jrektabasa.superhero.presentation.viewmodel.hero.HeroViewModel
import com.jrektabasa.superhero.ui.theme.SuperheroTheme
import com.jrektabasa.superhero.util.navigation.NavigationScreen
import dagger.hilt.android.AndroidEntryPoint

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroApp(
    navController: NavHostController = rememberNavController(),
    startDestination: String = NavigationScreen.DashBoard.route
) {

    val heroViewModel: HeroViewModel = viewModel()
    val heroByIdViewModel: HeroByIdViewModel = viewModel()

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "SuperHero") },
            navigationIcon = {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
            })
    }) {

        NavHost(
            navController = navController,
            startDestination = startDestination
        ) {
            composable(NavigationScreen.DashBoard.route) {
                DashBoardScreen(navHostController = navController, heroViewModel)
            }

            composable(
                NavigationScreen.Hero.route,
                arguments = listOf(navArgument("id") { type = NavType.StringType })
            ) { backStackEntry ->
                backStackEntry.arguments?.getString("id")?.let { id ->
                    HeroScreen(
                        navHostController = navController,
                        viewModel = heroByIdViewModel,
                        id = id
                    )
                }

            }
        }
    }


}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


//    val heroViewModel by viewModels<HeroViewModel>()
//    val heroByIdViewModel by viewModels<HeroByIdViewModel>()

//    private val biographyViewModel by viewModels<BiographyViewModel>()
//    private val authViewModel by viewModels<AuthViewModel>()

//    private val heroViewModel by viewModels<HeroViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            /* val authViewModel by viewModels<AuthViewModel>()
             val heroByIdViewModel by viewModels<HeroByIdViewModel>()


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
             )*/

            SuperheroTheme {
                HeroApp()
//                DashBoardScreen(heroViewModel)
//                HeroScreen(heroByIdViewModel)
//                SignInScreen(authViewModel)
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