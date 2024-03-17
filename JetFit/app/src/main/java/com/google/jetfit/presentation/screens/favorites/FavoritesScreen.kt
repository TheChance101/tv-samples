package com.google.jetfit.presentation.screens.favorites

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.tv.foundation.lazy.grid.TvGridCells
import androidx.tv.foundation.lazy.grid.TvLazyHorizontalGrid
import androidx.tv.foundation.lazy.grid.items
import androidx.tv.material3.Border
import androidx.tv.material3.Button
import androidx.tv.material3.ButtonBorder
import androidx.tv.material3.ButtonDefaults
import androidx.tv.material3.Card
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Icon
import androidx.tv.material3.Text
import coil.compose.AsyncImage
import com.google.jetfit.R
import com.google.jetfit.components.CustomCardWithIntensity
import com.google.jetfit.components.CustomFillIconButton
import com.google.jetfit.data.entities.FavWorkout
import com.google.jetfit.presentation.theme.onSurface
import com.google.jetfit.presentation.theme.onSurfaceVariant
import com.google.jetfit.presentation.theme.surface
import com.google.jetfit.presentation.theme.surfaceVariant

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun FavoritesScreen(favoritesViewModel: FavoritesViewModel = hiltViewModel()) {

    val uiState by favoritesViewModel.uiState.collectAsStateWithLifecycle()
    val selectedItem by favoritesViewModel.selectedWorkout.collectAsStateWithLifecycle()

    when (val value = uiState) {
        is FavoritesScreenUiState.Ready -> {
            FavoritesAlbum(
                modifier = Modifier,
                workoutsList = value.favoritesWorkouts,
                onWorkoutSelect = favoritesViewModel::onWorkoutSelect
            )
        }
        is FavoritesScreenUiState.Loading -> {
            Loading(modifier = Modifier.fillMaxSize())
        }
        is FavoritesScreenUiState.Error -> {
            Error(modifier = Modifier.fillMaxSize())
        }
    }
}


@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun FavoritesAlbum(
    modifier: Modifier = Modifier,
    workoutsList: List<FavWorkout>,
    onWorkoutSelect: (FavWorkout) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Favorites",
            modifier = Modifier.padding(bottom = 8.dp, top = 56.dp, start = 32.dp, end = 32.dp),
            style = TextStyle(
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.LightGray
            )
        )
        TvLazyHorizontalGrid(
            contentPadding = PaddingValues(horizontal = 46.dp),
            rows = TvGridCells.Fixed(2),
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp)
        ) {
            items(workoutsList) { item ->
                CustomCardWithIntensity(
                    modifier = Modifier
                        .width(196.dp)
                        .padding(horizontal = 12.dp),
                    imageUrl = item.image,
                    title = item.name,
                    timeText = item.duration,
                    typeText = "Intensity",
                    intensityLevel = item.intensity,
                    onClick = {
                        onWorkoutSelect(item)
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun Loading(modifier: Modifier = Modifier) {
    Text(text = "Loading...", modifier = modifier, textAlign = TextAlign.Center)
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun Error(modifier: Modifier = Modifier) {
    Text(text = "Wops, something went wrong.", modifier = modifier, textAlign = TextAlign.Center)
}