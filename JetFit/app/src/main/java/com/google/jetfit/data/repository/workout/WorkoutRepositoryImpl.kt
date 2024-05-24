package com.google.jetfit.data.repository.workout

import com.google.jetfit.data.entities.Intensity
import com.google.jetfit.data.entities.Language
import com.google.jetfit.data.entities.SubtitleLanguage
import com.google.jetfit.data.entities.Workout
import com.google.jetfit.data.entities.WorkoutType
import java.util.Date
import javax.inject.Inject

class WorkoutRepositoryImpl @Inject constructor() : WorkoutRepository {
    override fun getWorkouts(): List<Workout> = listOf(
        Workout(
            "1",
            "Back and leg strength",
            "Strong legs do more than look good. Even the simplest daily movements like walking require leg strength. But you may wonder where to begin. Let’s dive in.",
            "Charlotte Aldridge",
            WorkoutType.STRENGTH,
            "https://figmage.com/images/FbgDhnXP05yKpdsLJfTQo.png",
            "30",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            Intensity.HARD,
            Date(),
            Language.ENGLISH,
            SubtitleLanguage.ENGLISH,
            null
        ),
        Workout(
            "2",
            "Morning Yoga Flow",
            "Start your day with an energizing yoga routine. This flow focuses on awakening the body and mind, helping you feel refreshed and ready to tackle the day ahead.",
            "Emma Smith",
            WorkoutType.YOGA,
            "https://s3-alpha-sig.figma.com/img/aad6/dfa7/e5a9a9dd732084d30328dceec998666f?Expires=1711324800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Sr8NN2cvX3Bc~OmscqwR6VnQhe0Fri9~rM-D~i39wva-lyN6xG1ai7iNXYYa5Kn~uuDhyZ-0BvYVIM~Z2GciW~YMsZzPKyvfnMk92MZ3aVc1ik2fJmOG2SknBSxBuBO0lNRS0HNq-Zx~qe7JFfHC0gadAzzvCH4bB7sI01~HYYQzRjb9EYJdzkd9GkLXD9PaN0iN7in6QRDHSZdgrhT22J96TC3wxRH2mpfFsm3LYA0iSvdZgt6Zj11xrrLlfIvnGVST-SqYnpiv5ixoCHoS18N6Q0KALn7IBH3xk8MSWRnpdfwfjE-CtITEKfOc3YKOCkciHbuhasbdEYyNMHGGcg__",
            "30",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            Intensity.EASY,
            Date(),
            Language.ENGLISH,
            SubtitleLanguage.ENGLISH,
            null
        ),
        Workout(
            "3",
            "Strengthen & lengthen",
            "Experience an intense workout designed to maximize calorie burn and boost metabolism. This high-energy session combines bursts of intense exercise with short recovery periods for maximum results.",
            "John Doe",
            WorkoutType.CARDIO,
            "https://s3-alpha-sig.figma.com/img/5b76/28da/51c6b4c0076ea7b92c70d82dc1828425?Expires=1710720000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=M1NOL3tptpUBJ4qM0QbqmkCQBAKjWpNw3llpK70HUmcVyUPF9StrimFkFA32ziyk-X8GQz8VJHrT42ovbtj3ROiDwLBbLfpCbkuNaThYT5D0BAVkRZtSjkp~w3yDLQKdRSWp~1pn242mMj5ASFpYjL9udDM4JBHn9gjvzST7QGzvOHes9ZABFtimxVBC0Ot-eQDpDV7mbU9Pf5ROC2JTEd2LK-QG85N0Vv8cIFpUcPJGSFgR1tbHxMDv1GpKAx33eSGnH02~ow3R6sZm88wznn0AaPJoKwGGvU2ZJUVl6wbUD4JRt9gcs3q9FVFFEhSeoOpYbJSdqgWdzhPM-Lv-7Q__",
            "30",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            Intensity.HARD,
            Date(),
            Language.ENGLISH,
            SubtitleLanguage.ENGLISH,
            null
        ),
        Workout(
            "4",
            "Improve strength for run",
            "Discover the fundamentals of strength training with this beginner-friendly workout. Learn proper form and technique for key exercises to build a strong foundation for future progress.",
            "Maria Garcia",
            WorkoutType.STRENGTH,
            "https://s3-alpha-sig.figma.com/img/5b76/28da/51c6b4c0076ea7b92c70d82dc1828425?Expires=1710720000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=M1NOL3tptpUBJ4qM0QbqmkCQBAKjWpNw3llpK70HUmcVyUPF9StrimFkFA32ziyk-X8GQz8VJHrT42ovbtj3ROiDwLBbLfpCbkuNaThYT5D0BAVkRZtSjkp~w3yDLQKdRSWp~1pn242mMj5ASFpYjL9udDM4JBHn9gjvzST7QGzvOHes9ZABFtimxVBC0Ot-eQDpDV7mbU9Pf5ROC2JTEd2LK-QG85N0Vv8cIFpUcPJGSFgR1tbHxMDv1GpKAx33eSGnH02~ow3R6sZm88wznn0AaPJoKwGGvU2ZJUVl6wbUD4JRt9gcs3q9FVFFEhSeoOpYbJSdqgWdzhPM-Lv-7Q__",
            "30",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            Intensity.MEDIUM,
            Date(),
            Language.ENGLISH,
            SubtitleLanguage.SPANISH,
            null
        ),
        Workout(
            "5",
            "Workout with weights",
            "Unwind and release tension with this gentle evening stretch routine. Focus on deep breathing and gentle stretches to soothe tired muscles and promote relaxation, preparing you for a restful night's sleep.",
            "David Lee",
            WorkoutType.YOGA,
            "https://s3-alpha-sig.figma.com/img/5b76/28da/51c6b4c0076ea7b92c70d82dc1828425?Expires=1710720000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=M1NOL3tptpUBJ4qM0QbqmkCQBAKjWpNw3llpK70HUmcVyUPF9StrimFkFA32ziyk-X8GQz8VJHrT42ovbtj3ROiDwLBbLfpCbkuNaThYT5D0BAVkRZtSjkp~w3yDLQKdRSWp~1pn242mMj5ASFpYjL9udDM4JBHn9gjvzST7QGzvOHes9ZABFtimxVBC0Ot-eQDpDV7mbU9Pf5ROC2JTEd2LK-QG85N0Vv8cIFpUcPJGSFgR1tbHxMDv1GpKAx33eSGnH02~ow3R6sZm88wznn0AaPJoKwGGvU2ZJUVl6wbUD4JRt9gcs3q9FVFFEhSeoOpYbJSdqgWdzhPM-Lv-7Q__",
            "30",
            "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            Intensity.EASY,
            Date(),
            Language.ENGLISH,
            SubtitleLanguage.ENGLISH,
            null
        )
    )

    override fun getWorkoutById(id: String): Workout = getWorkouts().first { it.id == id }

}