package com.google.jetfit.data.repositories

import com.google.jetfit.data.entities.Song
import com.google.jetfit.data.entities.Workout
import javax.inject.Inject

class JetFitImpl @Inject constructor() : JetFitRepository {
    override fun getWorkouts() {
        TODO("Not yet implemented")
    }

    override fun getWorkoutById(id: String): Workout {
        return Workout(
            id = "123456sdasdsa",
            title = "Battle ropes HIIT",
            instructor = "Hugo Wright",
            videoUrl = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            subtitles = null,
            subtitleUri = null
        )
    }

    override fun getSongById(id: String): Song {
        return Song(
            id = "123456sdasdsa",
            title = "Power Workout",
            author = "Jake Diaz",
            createdDate = "2021",
            audioUrl = "",
            imageUrl = "https://images.unsplash.com/photo-1604480133080-602261a680df?q=80&w=1770&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        )
    }
}