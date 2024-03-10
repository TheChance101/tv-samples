package com.google.jetfit.data.repositories

import com.google.jetfit.data.entities.Category
import com.google.jetfit.data.entities.Session
import javax.inject.Inject

class JetFitImpl @Inject constructor() : JetFitRepository {
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

    override suspend fun getCategories(): List<Category> {
        return listOf(
            Category(
                imageUrl = "https://s3-alpha-sig.figma.com/img/5b76/28da/51c6b4c0076ea7b92c70d82dc1828425?Expires=1710720000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=M1NOL3tptpUBJ4qM0QbqmkCQBAKjWpNw3llpK70HUmcVyUPF9StrimFkFA32ziyk-X8GQz8VJHrT42ovbtj3ROiDwLBbLfpCbkuNaThYT5D0BAVkRZtSjkp~w3yDLQKdRSWp~1pn242mMj5ASFpYjL9udDM4JBHn9gjvzST7QGzvOHes9ZABFtimxVBC0Ot-eQDpDV7mbU9Pf5ROC2JTEd2LK-QG85N0Vv8cIFpUcPJGSFgR1tbHxMDv1GpKAx33eSGnH02~ow3R6sZm88wznn0AaPJoKwGGvU2ZJUVl6wbUD4JRt9gcs3q9FVFFEhSeoOpYbJSdqgWdzhPM-Lv-7Q__",
                title = "Yoga & Pilates",
                description = "There are many benefits to yoga and Pilates, including increased..."
            ),
            Category(
                imageUrl = "https://s3-alpha-sig.figma.com/img/9e9e/d62b/548d491bf82b615ac52bb7b20d5370e4?Expires=1710720000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=WkhebeHHgGiGxNoLU1V2VpriPOZagVf52bfaK~tadSr-C8DmUe5N~lcK8-cN~v2fwO2Y4pcekzf8EsIR72q1KQaOzYe~qcfUpb2VO8PD-vff-jJG2MQxQcOnQfZShjx4K9ttiOg2AfWYwMfMClsxrKHmk0gVDZl1owjwqKzRILlWC8zNZyLjzGijaOo0gHFRmpYMtXOcCn~IQhDkVo-X6lRx-4jb45AiMKLWLxjU3zjCFf1VLW1MbnaSNoyoPj4~4lIsXoTFcrAdQFrGhcjhArEgC7LgEMnJDJDigxipLJ3-wN5uuYNS7bz5CfsD1QzlYnjnp-ZsNbmT9kuEnVx-Dg__",
                title = "Strength training",
                description = "Strength training makes you stronger, helps you control your..."
            ),
            Category(
                imageUrl = "https://s3-alpha-sig.figma.com/img/c823/37df/f97a3d198ca7a463a530cdf43275e329?Expires=1710720000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=k9CLo2xpsEn07zCJElLridjmm4QdPO~oGTfQmSV1upDJZUteGoeHO~nvz8Jx7ZfZUiSyfg2rxMAWQPPgHncj9I-gHWgy9UTYWbiWuYq7ynct-4jdFdgPr1ltdoFsBRJR1~I05Js~YQi8rOUTdZy--9saib9eF~zGz10kC274EI2VT3V3xsF7XWErz2IDQ5LyDaO5rC1cS4S5H3tvzu20QlW8Kh73VaMMW70HydqB-rPrBEwljC9l3nIx8PK7BUHXxoNj0xPHOizXd6DN-JlHspxoU6N40wz4OfZc9oar-ZLGbT3mwHZrRdM0pUoHoIMr1flai50tU1t6jl-qw2QVPw__",
                title = "Aerobic & Cardio",
                description = "Get your blood pumping and build up your endurance with some..."
            ),
        )
    }
}