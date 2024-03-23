package com.stu74526.lab2_74526

sealed class Routes(val route: String) {
    object HomePage : Routes("home_page")
    object MovieActivity : Routes("movie_activity/{movieId}")
}