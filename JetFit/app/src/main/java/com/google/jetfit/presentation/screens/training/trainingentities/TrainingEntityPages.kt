package com.google.jetfit.presentation.screens.training.trainingentities

sealed class TrainingEntityPages {
    data object EntityDetails : TrainingEntityPages()
    data object EntityTabs : TrainingEntityPages()
}