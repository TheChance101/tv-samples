package com.google.jetfit.presentation.screens.player.audio

import javax.annotation.concurrent.Immutable

@Immutable
data class AudioPlayerUiState(
    val isLoading: Boolean = true,
    val error: String? = null,
)
