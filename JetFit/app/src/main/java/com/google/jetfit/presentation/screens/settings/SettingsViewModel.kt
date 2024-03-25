package com.google.jetfit.presentation.screens.settings

import androidx.lifecycle.ViewModel
import com.google.jetfit.data.repositories.JetFitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val jetFitRepository: JetFitRepository
) : ViewModel() {

    private val _settingsUIState = MutableStateFlow(SettingsUIState())
    val settingsUIState = _settingsUIState.asStateFlow()


}