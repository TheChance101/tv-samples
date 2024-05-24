package com.google.jetfit.data.repository.Series

import com.google.jetfit.data.entities.Intensity
import com.google.jetfit.data.entities.Language
import com.google.jetfit.data.entities.Series
import com.google.jetfit.data.entities.Song
import com.google.jetfit.data.entities.SubtitleLanguage
import com.google.jetfit.data.entities.WorkoutType
import java.util.Date
import javax.inject.Inject

class SeriesRepositoryImpl @Inject constructor() : SeriesRepository {

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

    override fun getSeries(): List<Series> = listOf(
        Series(
            "1",
            "Interval 5 day split",
            "Maximize your workouts with split training! Increase strength and build muscle in this 1-week guided program using heavier weights and targeting specific areas of the body in each workout. Repeat and track your progress!",
            "Andrew Trace",
            WorkoutType.SESSIONS,
            "https://figmage.com/images/FbgDhnXP05yKpdsLJfTQo.png",
            1L,
            5,
            30,
            "https://example.com/cardio_challenge_video.mp4",
            Intensity.HARD,
            Date(),
            Language.ENGLISH,
            SubtitleLanguage.ENGLISH
        ),
        Series(
            "2",
            "30-Day Cardio Challenge",
            "Take your fitness to the next level with our 30-day cardio challenge. Join trainer Alex Rodriguez in a series of high-intensity workouts designed to boost your endurance and burn calories.",
            "Alex Rodriguez",
            WorkoutType.CARDIO,
            "https://example.com/cardio_challenge.jpg",
            4L,
            20,
            45,
            "https://example.com/cardio_challenge_video.mp4",
            Intensity.HARD,
            Date(),
            Language.ENGLISH,
            SubtitleLanguage.ENGLISH
        ),
        Series(
            "3",
            "Strength Training Bootcamp",
            "Transform your physique with our intense strength training bootcamp. Led by fitness expert Mike Smith, this series includes challenging workouts to build muscle and increase strength.",
            "Mike Smith",
            WorkoutType.STRENGTH,
            "https://example.com/strength_training_bootcamp.jpg",
            6L,
            24,
            40,
            "https://example.com/strength_training_bootcamp_video.mp4",
            Intensity.MEDIUM,
            Date(),
            Language.ENGLISH,
            SubtitleLanguage.ENGLISH
        ),
        Series(
            "4",
            "Beginner Pilates Program",
            "Discover the benefits of Pilates with this beginner-friendly program. Led by instructor Emily White, this series focuses on core strength, flexibility, and body awareness.",
            "Emily White",
            WorkoutType.STRENGTH,
            "https://example.com/beginner_pilates_program.jpg",
            4L,
            16,
            35,
            "https://example.com/beginner_pilates_program_video.mp4",
            Intensity.EASY,
            Date(),
            Language.ENGLISH,
            SubtitleLanguage.ENGLISH
        ),
        Series(
            "5",
            "Yoga for Stress Relief",
            "Relieve stress and unwind with our yoga series designed to promote relaxation and mental well-being. Join instructor Lisa Taylor in a series of gentle yoga practices and guided meditation sessions.",
            "Lisa Taylor",
            WorkoutType.YOGA,
            "https://example.com/yoga_stress_relief.jpg",
            3L,
            12,
            25,
            "https://example.com/yoga_stress_relief_video.mp4",
            Intensity.EASY,
            Date(),
            Language.ENGLISH,
            SubtitleLanguage.ENGLISH
        ),
        Series(
            "6",
            "Total Body Burn",
            "Torch calories and sculpt your physique with this high-intensity total body workout series. Led by trainer Chris Johnson, each session targets multiple muscle groups for maximum results.",
            "Chris Johnson",
            WorkoutType.STRENGTH,
            "https://example.com/total_body_burn.jpg",
            5L,
            20,
            40,
            "https://example.com/total_body_burn_video.mp4",
            Intensity.HARD,
            Date(),
            Language.ENGLISH,
            SubtitleLanguage.ENGLISH
        ),
        Series(
            "7",
            "Prenatal Yoga Series",
            "Stay active and prepare for childbirth with our prenatal yoga series. Led by experienced instructor Rachel Adams, these gentle practices focus on strengthening the body and calming the mind during pregnancy.",
            "Rachel Adams",
            WorkoutType.YOGA,
            "https://example.com/prenatal_yoga.jpg",
            3L,
            10,
            30,
            "https://example.com/prenatal_yoga_video.mp4",
            Intensity.EASY,
            Date(),
            Language.ENGLISH,
            SubtitleLanguage.ENGLISH
        ),
        Series(
            "8",
            "Advanced HIIT Workouts",
            "Challenge yourself with our advanced HIIT series designed for experienced fitness enthusiasts. Led by trainer Mark Thompson, these high-intensity interval workouts will push your limits and take your fitness to new heights.",
            "Mark Thompson",
            WorkoutType.CARDIO,
            "https://example.com/advanced_hiit.jpg",
            6L,
            18,
            50,
            "https://example.com/advanced_hiit_video.mp4",
            Intensity.HARD,
            Date(),
            Language.ENGLISH,
            SubtitleLanguage.ENGLISH
        ),
        Series(
            "9",
            "Core Strength Challenge",
            "Build a strong and stable core with our intensive core strength challenge series. Led by instructor Jessica Miller, these targeted workouts will help you develop abdominal strength and improve posture.",
            "Jessica Miller",
            WorkoutType.STRENGTH,
            "https://example.com/core_strength_challenge.jpg",
            4L,
            16,
            35,
            "https://example.com/core_strength_challenge_video.mp4",
            Intensity.MEDIUM,
            Date(),
            Language.ENGLISH,
            SubtitleLanguage.ENGLISH
        )
    )

    override fun getSeriesById(id: String): Series = getSeries().first { it.id == id }

}