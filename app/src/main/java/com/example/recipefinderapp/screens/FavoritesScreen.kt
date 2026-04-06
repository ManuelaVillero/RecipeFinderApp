package com.example.recipefinderapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recipefinderapp.viewmodel.RecipeViewModel

@Composable
fun FavoritesScreen(navController: NavController, viewModel: RecipeViewModel) {
    val favorites by viewModel.favorites.collectAsState(initial = emptyList())

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Favorites", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        if (favorites.isEmpty()) {
            Text("No favorite recipes yet.")
        } else {
            LazyColumn {
                items(favorites) { recipe ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(recipe.strMeal, style = MaterialTheme.typography.titleMedium)
                            Text(recipe.strCategory ?: "No category")

                            Spacer(modifier = Modifier.height(8.dp))

                            Button(onClick = { viewModel.deleteFavorite(recipe.idMeal) }) {
                                Text("Remove")
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("Back")
        }
    }
}