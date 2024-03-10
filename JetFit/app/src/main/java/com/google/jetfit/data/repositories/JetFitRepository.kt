package com.google.jetfit.data.repositories

import com.google.jetfit.data.entities.Category
import com.google.jetfit.data.entities.Session

interface JetFitRepository {
    fun getWorkouts()
    fun getWorkoutById()
    suspend fun getSessions(): List<Session>
    suspend fun getCategories(): List<Category>

}