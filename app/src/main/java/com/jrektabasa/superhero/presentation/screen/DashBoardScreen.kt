package com.jrektabasa.superhero.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
//import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.presentation.viewmodel.hero.HeroViewModel
import com.jrektabasa.superhero.util.navigation.NavigationScreen

import com.jrektabasa.superhero.data.model.response.Result

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashBoardScreen(
    navHostController: NavHostController,
    viewModel: HeroViewModel
) {

    val heroListState by viewModel.characterList.collectAsState()

//    navHostController.navigate(
////                            NavigationScreen.Hero.route.replace(
////                                "{id}", "${hero.heroId}"
////                            )
////                        )

    heroListState?.let { result ->
        val characterList = result.data.results
        LazyColumn {
            items(items = characterList) { character ->
                HeroCard(character = character)
            }
        }
    }

}

@Composable
fun HeroCard(character: Result) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        shape = RoundedCornerShape(25.dp),
        modifier = Modifier
            .padding(
                start = 20.dp,
                end = 20.dp,
                top = 10.dp,
                bottom = 10.dp
            )
            .height(200.dp)
            .clickable {

            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = "${character.thumbnail.path}.${character.thumbnail.extension}",
                contentDescription = null,
                modifier = Modifier.size(width = 160.dp, height = 200.dp),
                contentScale = ContentScale.Crop,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        16.dp
                    )
            ) {

                Text(
                    text = character.name,
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold

                )
                Text(text = character.description, color = Color.Gray,
                    fontSize = 15.sp)
                Text(text = "more")
            }
        }
    }

}