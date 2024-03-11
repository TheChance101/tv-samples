package com.google.jetfit.presentation.screens.home

import com.google.jetfit.data.entities.Category
import com.google.jetfit.data.entities.Recommended
import com.google.jetfit.data.entities.Session

data class HomeUiState(
    val contentStatus: ContentStatus = ContentStatus.LOADING,
    val categories: List<Category> = listOf(),
    val sessions: List<Session> = emptyList(),
    val recommended: List<Recommended> = listOf()
) {
    enum class ContentStatus {
        LOADING,
        VISIBLE,
        ERROR
    }
}