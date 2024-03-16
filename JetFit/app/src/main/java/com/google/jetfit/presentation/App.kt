package com.google.jetfit.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.jetfit.presentation.screens.Screens
import com.google.jetfit.presentation.screens.video_player.VideoPlayerScreen

@Composable
fun App(
    onBackPressed: () -> Unit
) {

    val navController = rememberNavController()
    var isComingBackFromDifferentScreen by remember { mutableStateOf(false) }
    NavHost(
        navController = navController,
        startDestination = Screens.Home(),
        builder = {
            composable(
                route = Screens.Home(),
                arguments = listOf(
                    navArgument("") {
                        type = NavType.StringType
                    }
                )
            ) {

            }
            composable(
                route = Screens.VideoPlayer(),
                arguments = listOf(
                    navArgument("") {
                        type = NavType.StringType
                    }
                )
            ) {
                VideoPlayerScreen(onBackPressed)
            }
        }
    )
}