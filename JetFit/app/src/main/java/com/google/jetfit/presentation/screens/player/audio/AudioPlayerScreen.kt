package com.google.jetfit.presentation.screens.player.audio

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.jetfit.presentation.theme.JetFitTheme

@Composable
fun AudioPlayerScreen(viewModel: AudioPlayerViewModel = hiltViewModel()) {
    AudioPlayerContent()
}

@Composable
private fun AudioPlayerContent() {

}


@Preview(device = Devices.TV_1080p)
@Composable
fun PreviewVideoPlayerScreen() {
    JetFitTheme {
        AudioPlayerContent()
    }
}