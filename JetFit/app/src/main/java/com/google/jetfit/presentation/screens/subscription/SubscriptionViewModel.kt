package com.google.jetfit.presentation.screens.subscription

import androidx.lifecycle.ViewModel
import com.google.jetfit.data.repositories.JetFitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class SubscriptionViewModel @Inject constructor(
    private val jetFitRepository: JetFitRepository
): ViewModel() {

}