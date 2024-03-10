package com.google.jetfit.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.tv.foundation.lazy.list.TvLazyColumn
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.material3.Card
import androidx.tv.material3.CarouselState
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import com.google.jetfit.presentation.screens.home.components.HomeCategory
import com.google.jetfit.presentation.screens.home.components.SessionsCard

@OptIn(ExperimentalTvMaterial3Api::class)
val carouselSaver =
    Saver<CarouselState, Int>(save = { it.activeItemIndex }, restore = { CarouselState(it) })

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = hiltViewModel()
    val state by viewModel.state.collectAsState()

    val carouselState = rememberSaveable(saver = carouselSaver) { CarouselState(0) }

    HomeContent(
        state = state,
        carouselState = carouselState,
    )
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun HomeContent(
    state: HomeUiState,
    carouselState: CarouselState,
) {
    TvLazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        item {
            SessionsCard(
                sessions = state.sessions,
                padding = PaddingValues(horizontal = 58.dp, vertical = 36.dp),
                onCLickStartSession = { },
                carouselState = carouselState,
                modifier = Modifier.aspectRatio(21F / 9F)
            )
        }
        item {
            HomeCategory(
                categories = state.categories,
                onClick = {}
            )
        }
        item {
            TvLazyRow() {
                items(state.sessions.size) {
                    Card(onClick = { }) {
                        Text(text = state.sessions[it].title)
                    }
                }
            }
        }

    }


}
