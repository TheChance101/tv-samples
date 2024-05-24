package com.google.jetfit.data.repository

import com.google.jetfit.data.entities.Category
import com.google.jetfit.data.entities.FavList
import com.google.jetfit.data.entities.Profile
import com.google.jetfit.data.entities.Routine
import com.google.jetfit.data.entities.Session
import com.google.jetfit.data.entities.Subscription
import com.google.jetfit.data.entities.Training
import com.google.jetfit.data.entities.TrainingDetails
import kotlinx.coroutines.flow.Flow

interface JetFitRepository {

    suspend fun getInstructors():List<String>

    fun getRoutines(): List<Routine>
    fun getRoutineById(id: String): Routine

    suspend fun getSessions(): List<Session>
    suspend fun getCategories(): List<Category>
    suspend fun getTrainingsRecommended(): List<Training>
    fun getTrainingById(id: Int): Flow<TrainingDetails>
    suspend fun getUserProfiles(): List<Profile>

    fun getFavoritesWorkouts(): Flow<FavList>

    fun getSubscriptionOptionsByInstructorId(instructorId: String): Flow<List<Subscription>>
    suspend fun getInstructorImageById(instructorId: String): String

}