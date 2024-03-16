package com.google.jetfit.presentation.screens.player.audio

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.media3.common.MediaItem
import androidx.media3.common.Player
import androidx.media3.exoplayer.ExoPlayer
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.MaterialTheme
import coil.compose.AsyncImage
import com.google.jetfit.R
import com.google.jetfit.presentation.screens.player.composable.PlayerTitle
import com.google.jetfit.presentation.theme.JetFitTheme
import kotlinx.coroutines.delay

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

    val context = LocalContext.current
    val exoPlayer = remember {
        ExoPlayer.Builder(context)
            .build()
            .apply {
                playWhenReady = true
                repeatMode = Player.REPEAT_MODE_ONE
            }
    }

    LaunchedEffect(exoPlayer, state) {
        exoPlayer.setMediaItem(
            MediaItem.Builder()
                .setUri(state.audioUrl)
                .build()
        )
        exoPlayer.prepare()
    }

    var contentCurrentPosition by remember { mutableLongStateOf(0L) }
    var isPlaying: Boolean by remember { mutableStateOf(exoPlayer.isPlaying) }
    LaunchedEffect(Unit) {
        while (true) {
            delay(1000)
            contentCurrentPosition = exoPlayer.currentPosition
            isPlaying = exoPlayer.isPlaying
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            modifier = Modifier
                .size(196.dp)
                .clip(RoundedCornerShape(16.dp)),
            model = state.imageUrl,
            contentDescription = stringResource(R.string.song_image),
            contentScale = ContentScale.Crop
        )

        PlayerTitle(
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            title = state.title,
            secondaryText = "${state.author} • ${state.date}",
            titleStyle = MaterialTheme.typography.headlineMedium,
            secondaryTextStyle = MaterialTheme.typography.bodyMedium,
        )
    }
}


@Preview(device = Devices.TV_1080p)
@Composable
fun PreviewVideoPlayerScreen() {
    JetFitTheme {
        AudioPlayerContent(SongUiState()) {}
    }
}