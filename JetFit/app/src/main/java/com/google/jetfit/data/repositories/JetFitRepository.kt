package com.google.jetfit.data.repositories

import com.google.jetfit.data.entities.Song
import com.google.jetfit.data.entities.Workout

import com.google.jetfit.data.entities.Category
import com.google.jetfit.data.entities.Session
import com.google.jetfit.data.entities.Subscription
import com.google.jetfit.data.entities.Training
import kotlinx.coroutines.flow.Flow

interface JetFitRepository {
    fun getWorkouts()
    fun getWorkoutById(id: String): Workout
    fun getSongById(id: String): Song
    fun getWorkoutById()
    suspend fun getSessions(): List<Session>
    suspend fun getCategories(): List<Category>
    suspend fun getTrainingsRecommended(): List<Training>

    fun getSubscriptionOptionsByInstructorId(instructorId: String): Flow<List<Subscription>>
    suspend fun getInstructorImageById(instructorId: String): String

}