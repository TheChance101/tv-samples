package com.google.jetfit.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.jetfit.presentation.screens.Screens
import com.google.jetfit.presentation.screens.player.audio.AudioPlayerScreen
import com.google.jetfit.presentation.screens.player.video.VideoPlayerScreen
import com.google.jetfit.presentation.screens.dashboard.DashboardScreen
import com.google.jetfit.presentation.utils.navigateTo
import com.google.jetfit.presentation.utils.navigationDrawerGraph

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun App(
    onBackPressed: () -> Unit
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        route = "root_host",
        startDestination = Screens.Dashboard(),
        builder = {
            navigationDrawerGraph(
                    onNavigateToRoot = navController::navigateTo,
                    onBackPressed = onBackPressed
            )
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
                VideoPlayerScreen(onBackPressed = onBackPressed)
            }
            composable(
                route = Screens.AudioPlayer(),
                arguments = listOf(
                    navArgument("") {
                        type = NavType.StringType
                    }
                )
            ) {
                AudioPlayerScreen(onBackPressed = onBackPressed)
            }
        }
    )
}

