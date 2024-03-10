package com.google.jetfit.presentation.screens.home

import com.google.jetfit.data.entities.Session

data class HomeUiState(
    val isLoading: Boolean = true,
    val sessions: List<Session> = emptyList(),
)