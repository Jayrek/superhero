package com.jrektabasa.superhero.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.presentation.viewmodel.hero.HeroByIdViewModel

@Composable
fun HeroScreen(
    navHostController: NavHostController,
    viewModel: HeroByIdViewModel,
    id: String,
) {
    LaunchedEffect(true) {
        viewModel.getHeroInfo(id)
    }

    val heroState by viewModel.hero.collectAsState()

    heroState?.let { result ->
        when (result) {
            is Result.Success -> {
                val hero = result.data
                Box(modifier = Modifier.fillMaxSize()) {

                    AsyncImage(
                        model = hero.image.url,
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                    )

                    Column(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(16.dp)
                    ) {
                        Row {
                            Text("Power", color = Color.White)
                            Text(hero.powerStats.power, color = Color.White)
                        }
                        Row {
                            Text("Intelligence", color = Color.White)
                            Text(hero.powerStats.intelligence, color = Color.White)
                        }
                        Row {
                            Text("Strength", color = Color.White)
                            Text(hero.powerStats.strength, color = Color.White)
                        }
                        Row {
                            Text("Speed", color = Color.White)
                            Text(hero.powerStats.speed, color = Color.White)
                        }
                        Row {
                            Text("Durability", color = Color.White)
                            Text(hero.powerStats.durability, color = Color.White)
                        }
                        Row {
                            Text("Combat", color = Color.White)
                            Text(hero.powerStats.combat, color = Color.White)
                        }
                    }
                }
            }

            is Result.Error -> TODO()
        }
    }

}


//@Preview
//@Composable
//fun HeroScreenPreview() {
//    HeroScreen()
//}