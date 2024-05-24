package com.google.jetfit.data.repository.challenges

import com.google.jetfit.data.entities.Challenge
import com.google.jetfit.data.entities.Intensity
import com.google.jetfit.data.entities.Language
import com.google.jetfit.data.entities.SubtitleLanguage
import com.google.jetfit.data.entities.Workout
import com.google.jetfit.data.entities.WorkoutType
import java.util.Date
import javax.inject.Inject

class ChallengesRepositoryImpl @Inject constructor(
    private val getWorkouts: () -> List<Workout>
) : ChallengesRepository{

    override fun getChallenges(): List<Challenge> =
        listOf(
            Challenge(
                "1",
                "30 Days of HIIT & mindfulness",
                "Build your full body endurance with high-intensity training drills, kick boxing and more. Quick workouts to warm up before or cool down after your run.",
                "Hugo Wright",
                WorkoutType.CHALLENGE,
                "https://figmage.com/images/FbgDhnXP05yKpdsLJfTQo.png",
                30,
                15,
                generateWeeklyPlans(getWorkouts()),
                Intensity.EASY,
                Date(),
                Language.ENGLISH,
                SubtitleLanguage.ENGLISH
            ),
            Challenge(
                "2",
                "30-Day Cardio Challenge",
                "Join our 30-day cardio challenge and boost your fitness level with high-intensity cardio workouts. Led by expert trainer Alex Rodriguez, this challenge will push your limits and help you achieve your fitness goals.",
                "Alex Rodriguez",
                WorkoutType.CARDIO,
                "https://example.com/cardio_challenge.jpg",
                45,
                30,
                generateWeeklyPlans(getWorkouts()),
                Intensity.HARD,
                Date(),
                Language.ENGLISH,
                SubtitleLanguage.ENGLISH
            ),
            Challenge(
                "3",
                "21-Day Yoga Journey",
                "Embark on a transformative 21-day yoga journey to cultivate inner peace and physical strength. Led by renowned instructor Sarah Johnson, this challenge includes daily yoga practices designed to rejuvenate your mind, body, and soul.",
                "Sarah Johnson",
                WorkoutType.YOGA,
                "https://example.com/yoga_journey.jpg",
                30,
                21,
                generateWeeklyPlans(getWorkouts()),
                Intensity.MEDIUM,
                Date(),
                Language.ENGLISH,
                SubtitleLanguage.ENGLISH
            ),
            Challenge(
                "4",
                "14-Day Strength Training Challenge",
                "Build muscle and increase strength with our 14-day strength training challenge. Led by fitness expert Mike Smith, this challenge includes daily workouts targeting different muscle groups to help you sculpt your ideal physique.",
                "Mike Smith",
                WorkoutType.STRENGTH,
                "https://example.com/strength_training_challenge.jpg",
                40,
                14,
                generateWeeklyPlans(getWorkouts()),
                Intensity.MEDIUM,
                Date(),
                Language.ENGLISH,
                SubtitleLanguage.ENGLISH
            )
        )

    override fun getChallengeById(id: String): Challenge = getChallenges().first { it.id == id }

    private fun generateWeeklyPlans(availableWorkouts: List<Workout>): List<Pair<String, List<Workout>>> {
        val shuffledWorkouts = availableWorkouts.shuffled().take(5)
        return listOf(
            "Week 1: Meet the basics" to shuffledWorkouts.shuffled(),
            "Week 2: Get your footing" to shuffledWorkouts.shuffled(),
            "Week 3: Expand your style" to shuffledWorkouts.shuffled(),
            "Week 4: Challenge yourself" to shuffledWorkouts.shuffled()
        )
    }
}