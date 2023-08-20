package com.jrektabasa.superhero.presentation.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.presentation.viewmodel.hero.HeroViewModel
import com.jrektabasa.superhero.util.navigation.NavigationScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashBoardScreen(
    navHostController: NavHostController,
    viewModel: HeroViewModel
) {

    val heroListState by viewModel.heroList.collectAsState()

    heroListState?.let { result ->
        when (result) {
            is Result.Success -> {
                val heroList = result.data

                LazyColumn {
                    items(items = heroList) { hero ->
                        ListItem(modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                            .clickable {
                                navHostController.navigate(
                                    NavigationScreen.Hero.route.replace(
                                        "{id}", "${hero.heroId}"
                                    )
                                )

                            }, headlineText = {
                            Text(text = hero.name)
                        }, supportingText = {
                            Text(text = "${hero.heroId}")
                        })

                    }
                }
            }

            is Result.Error -> {}
        }
    }
}