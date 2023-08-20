package com.jrektabasa.superhero.presentation.screen

import android.util.Log
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
import com.jrektabasa.superhero.data.common.Result
import com.jrektabasa.superhero.presentation.viewmodel.hero.HeroViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashBoardScreen(viewModel: HeroViewModel) {
    val heroListState by viewModel.heroList.collectAsState()

    heroListState?.let { result ->
        when (result) {
            is Result.Success -> {
                val heroList = result.data

                LazyColumn {
                    items(items = heroList) { hero ->
                        ListItem(
                            modifier = Modifier
                                .padding(16.dp)
                                .clickable {
                                    Log.wtf("clicked: ", hero.name)
                                }, headlineText = {
                                Text(text = hero.name)
                            })

                    }
                }
            }

            is Result.Error -> {}
        }
    }
}