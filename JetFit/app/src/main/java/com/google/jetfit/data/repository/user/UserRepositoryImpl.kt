package com.google.jetfit.data.repository.user

import com.google.jetfit.data.entities.Profile
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(

):UserRepository {
    override suspend fun getUserProfiles(): List<Profile> {
        return listOf(
            Profile(
                id = "1",
                name = "Liam",
                avatar = "https://s3-alpha-sig.figma.com/img/6532/e8f4/1392cf3e62810b5ea04afa65d9b72a51?Expires=1711929600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=R4~LhpixBseeXvgcgkOo87m1tVPmfIsU84BxBo686p-2JdNJc-4niyDJ~4SzLm3f~PKFKtSHVnBoPIFJJEQBBJE3m2UpwdH~-O7FqGIy9lsSdmf82l3vCGPNgX6tLFUkSxD9J4IvwJYd1kYusUhdxVN04M2Zr-O7dT9uUVEvnBrNKSw6taqoGJMDih3Luc8SGfMllrc9uFAM1oKOQJxpkqqzJCj3FpMVzJ5BEuftlcQd1q4PhSp7V9LwPS1n0tcfT02X-NyuBxIWl3wzO8~kpXyqFv83MVqJaGDBugERlGbe5L-vnHhDgybST0SbPSBtAgciKXO4yZpfy9hf5-X57w__"
            ),
            Profile(
                id = "2",
                name = "Olivia",
                avatar = "https://s3-alpha-sig.figma.com/img/3f0e/6a39/508338655b58ecb681612b7c83ffe0bc?Expires=1711929600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=RQuElmLChyZ8-iqnobcT73flYdOez2iSBeGnKKKB1qd67RF4BONYtKHbZWyvaW~W7qPGCykK~82TOeGhSoKACspW9rHYG4nCqG7bD8GCXOCv4MFks5sna~0D6tpWInNmcFxLpHe7v9mHn1GVfa5jq5TMWVk2GWcHNydtMnVr6f1gSiOthkjQ8z3ALjob6WtJlA9RaDuYebNvJ1oxRis6o9QArvO3dknVaQQLnmB2FtoVv-AiWsQoCTiCy6Jp8WiVKF7SGGS-WRd8qQS9YUKY8FHgcpvoAum5Cn6HCksECIsz5oonVuDAyJSil3v9fyG5VnzzE9~IacQUA~E2ZeSFlg__"
            ),
            Profile(
                id = "3",
                name = "Noah",
                avatar = "https://s3-alpha-sig.figma.com/img/3c0b/7630/a6c58e76e1e55007c4ef8859cacb4398?Expires=1711929600&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=AlCz1j9iK0OhpkYbrtd1MGytk-1Q9lp51IiF5bkM6ri9Hilgke9REJCZj3eYESxoQLlJEE9LfYmdCPwKHuL5ttaKNjI9Y7R1U88049F8Quy4BIAHo8hV1ZLVp2CoKk9JP7ydMHwicJSwqAyfKokI3GNN1A~GBOoSPX-skdmLx3VK5nleWjtZl4dyxQ77ffnUHLC4lVW55m0Bj5t~3vh6-ZZ6Veu-aOO~r9I9EA4aIiwCLu0HbIN5mal98MXyO2eRqZpvgRffmLHcJPblCWjUhunugwtIaBXbv8GEFM7y0w5F60VhDumHZkhu-ASESrs-3nDCLnV7268z-ifqCat~6Q__"
            ),
        )
    }

}