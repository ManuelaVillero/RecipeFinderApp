package com.example.recipefinderapp.navigation

sealed class Screen(val route: String) {
    object Search : Screen("search")
    object Details : Screen("details")
    object Favorites : Screen("favorites")
}