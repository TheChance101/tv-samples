package com.google.jetfit.data.repository.workout

import com.google.jetfit.data.entities.Workout

interface WorkoutRepository {
    fun getWorkouts(): List<Workout>

    fun getWorkoutById(id: String): Workout
}