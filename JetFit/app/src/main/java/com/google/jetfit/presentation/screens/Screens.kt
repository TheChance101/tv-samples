package com.google.jetfit.presentation.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

enum class Screens(
    val  route: String,
    private val args: List<String>? = null,
    var routePath: String? = null,
    var clearBackStack: Boolean = false,
    val isNavigationDrawerItem: Boolean = false,
    val navigationDrawerIcon: ImageVector? = null
) {
    Dashboard("dashboard"),
    Search("search", isNavigationDrawerItem =true, navigationDrawerIcon = Icons.Filled.Search),
    FitnessCenter("fitnessCenter", isNavigationDrawerItem = true, navigationDrawerIcon = Icons.Filled.AddCircle),
    Favorite("favorite", isNavigationDrawerItem = true, navigationDrawerIcon = Icons.Filled.Favorite),
    Settings("settings", isNavigationDrawerItem = true, navigationDrawerIcon = Icons.Filled.Settings),
    Home("home", isNavigationDrawerItem = true, navigationDrawerIcon = Icons.Filled.Home);

    operator fun invoke(): String {
        val argList = StringBuilder()
        args?.let { nnArgs ->
            nnArgs.forEach { arg -> argList.append("/{$arg}") }
        }
        return name + argList
    }

    fun withArgs(vararg args: Any): String {
        val destination = StringBuilder()
        args.forEach { arg -> destination.append("/$arg") }
        return name + destination
    }
}
