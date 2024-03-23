package com.stu74526.lab2_74526

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HomePage.route,
    ) {
        composable(route = Routes.HomePage.route)
        {
            Home(navController = navController)
        }
        composable(route = Routes.MovieActivity.route + "/{movieId}",
            arguments = listOf(navArgument("movieId") { defaultValue = "0"}))
        {
                backStackEntry ->
            MovieScreen(
                navController = navController,
                backStackEntry.arguments?.getString("movieId"))
        }
    }
}