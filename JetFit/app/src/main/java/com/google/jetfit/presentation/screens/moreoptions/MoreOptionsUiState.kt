package com.google.jetfit.presentation.screens.moreoptions

import com.google.jetfit.data.entities.TrainingDetails

sealed interface MoreOptionsUiState {
    data object Loading : MoreOptionsUiState
    data object Error : MoreOptionsUiState
    data class Ready(
        val trainingDetails: TrainingDetails
    ) : MoreOptionsUiState {
        fun formatTimeAndTypeTraining(): String {
            return "${trainingDetails.time} | ${trainingDetails.type} ••••"
        }
    }
}
