package com.google.jetfit.presentation.screens.player.audio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.jetfit.presentation.theme.JetFitTheme

@Composable
fun AudioPlayerScreen(viewModel: AudioPlayerViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    AudioPlayerContent()
}

@Composable
private fun AudioPlayerContent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

    }
}


@Preview(device = Devices.TV_1080p)
@Composable
fun PreviewVideoPlayerScreen() {
    JetFitTheme {
        AudioPlayerContent()
    }
}