package com.example.recipefinderapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recipefinderapp.data.AppDatabase
import com.example.recipefinderapp.data.RecipeRepository
import com.example.recipefinderapp.navigation.Screen
import com.example.recipefinderapp.screens.DetailsScreen
import com.example.recipefinderapp.screens.FavoritesScreen
import com.example.recipefinderapp.screens.SearchScreen
import com.example.recipefinderapp.ui.theme.RecipeFinderAppTheme
import com.example.recipefinderapp.viewmodel.RecipeViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val dao = AppDatabase.getDatabase(applicationContext).favoriteRecipeDao()
        val repository = RecipeRepository(dao)

        setContent {
            RecipeFinderAppTheme {
                val navController = rememberNavController()

                val recipeViewModel: RecipeViewModel = viewModel(
                    factory = object : ViewModelProvider.Factory {
                        override fun <T : ViewModel> create(modelClass: Class<T>): T {
                            return RecipeViewModel(repository) as T
                        }
                    }
                )

                NavHost(
                    navController = navController,
                    startDestination = Screen.Search.route
                ) {
                    composable(Screen.Search.route) {
                        SearchScreen(navController, recipeViewModel)
                    }

                    composable(Screen.Details.route) {
                        DetailsScreen(navController, recipeViewModel)
                    }

                    composable(Screen.Favorites.route) {
                        FavoritesScreen(navController, recipeViewModel)
                    }
                }
            }
        }
    }
}