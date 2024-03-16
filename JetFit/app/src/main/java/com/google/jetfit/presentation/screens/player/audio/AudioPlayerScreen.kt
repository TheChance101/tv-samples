package com.google.jetfit.presentation.screens.player.audio

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import coil.compose.AsyncImage
import com.google.jetfit.R
import com.google.jetfit.presentation.screens.player.composable.PlayerTitle
import com.google.jetfit.presentation.theme.JetFitTheme

@Composable
fun AudioPlayerScreen(
    viewModel: AudioPlayerViewModel = hiltViewModel(),
    onBackPressed: () -> Unit,
) {
    val state by viewModel.state.collectAsState()
    AudioPlayerContent(state = state.songUiState, onBackPressed = onBackPressed)
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun AudioPlayerContent(
    state: SongUiState,
    onBackPressed: () -> Unit,
) {
    BackHandler(onBack = onBackPressed)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(16.dp)),
            model = state.imageUrl,
            contentDescription = stringResource(R.string.song_image),
            contentScale = ContentScale.Crop
        )

        PlayerTitle(title = state.title, secondaryText = "${state.author} • ${state.date}")
    }
}


@Preview(device = Devices.TV_1080p)
@Composable
fun PreviewVideoPlayerScreen() {
    JetFitTheme {
        AudioPlayerContent(SongUiState()) {}
    }
}