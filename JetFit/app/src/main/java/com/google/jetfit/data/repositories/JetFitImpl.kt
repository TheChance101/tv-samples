package com.google.jetfit.data.repositories

import com.google.jetfit.data.entities.Session
import javax.inject.Inject

class JetFitImpl @Inject constructor() : JetFitRepository{
    override fun getWorkouts() {
        TODO("Not yet implemented")
    }

    override fun getWorkoutById() {
        TODO("Not yet implemented")
    }

    override suspend fun getSessions(): List<Session> {
        return listOf(
            Session(
                id = "1",
                instructor = "Danielle Orlando",
                title = "Strengthen & lengthen pilates",
                description = "This pilates workout is perfect for good balance between your overall strength and flexibility. Use your own body weight to strengthen and sculpt our muscles",
                imageUrl = "https://cdn.muscleandstrength.com/sites/default/files/strong-brunette-doing-shoulder-press.jpg"
            ),
            Session(
                id = "2",
                instructor = "John Smith",
                title = "Yoga Flow",
                description = "Join us for a relaxing yoga flow session to unwind and improve flexibility. Suitable for all levels.",
                imageUrl = "https://1.bp.blogspot.com/-06DVesUYzOQ/Xxff6Ysq8VI/AAAAAAAABJ0/HljMYwQN9iEOcuBIRrTmzVMiYQWekkvWgCLcBGAsYHQ/s640/vinyasa.jpg"
            ),
            Session(
                id = "3",
                instructor = "Emily Johnson",
                title = "HIIT Workout",
                description = "Get ready to sweat with our high-intensity interval training (HIIT) session. Burn calories, build strength, and improve endurance!",
                imageUrl = "https://static01.nyt.com/images/2023/03/21/multimedia/14WNT-HIIT-WORKOUTS1-lktg/14WNT-HIIT-WORKOUTS1-lktg-videoSixteenByNine3000.jpg"
            ),
            Session(
                id = "4",
                instructor = "Michael Thompson",
                title = "Boxing Bootcamp",
                description = "Punch and kick your way to fitness with our boxing bootcamp! Improve your coordination, agility, and strength while having fun.",
                imageUrl = "https://clubwoodside.com/wp-content/uploads/2019/02/Woodside_GX_Boxing-1080x675-1.jpg"
            ),
        )

    }
}