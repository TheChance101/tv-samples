package com.google.jetfit.presentation.screens.player.audio

import androidx.lifecycle.ViewModel
import com.google.jetfit.data.repositories.JetFitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AudioPlayerViewModel @Inject constructor(
    private val jetFitRepository: JetFitRepository
) : ViewModel() {
    private val _state = MutableStateFlow(AudioPlayerUiState())
    val state get() = _state.asStateFlow()
}