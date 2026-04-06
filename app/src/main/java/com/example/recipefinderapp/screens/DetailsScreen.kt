package com.example.recipefinderapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recipefinderapp.data.FavoriteRecipe
import com.example.recipefinderapp.viewmodel.RecipeViewModel

@Composable
fun DetailsScreen(navController: NavController, viewModel: RecipeViewModel) {
    val recipes by viewModel.recipes.collectAsState()
    val selectedRecipe = recipes.firstOrNull()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        // BACK BUTTON AT TOP
        Button(onClick = { navController.popBackStack() }) {
            Text("← Back")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Recipe Details",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (selectedRecipe != null) {

            Text(
                text = "Name: ${selectedRecipe.strMeal}",
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            // FAVORITE BUTTON AT TOP
            Button(
                onClick = {
                    viewModel.addFavorite(
                        FavoriteRecipe(
                            idMeal = selectedRecipe.idMeal,
                            strMeal = selectedRecipe.strMeal,
                            strCategory = selectedRecipe.strCategory,
                            strArea = selectedRecipe.strArea,
                            strInstructions = selectedRecipe.strInstructions,
                            strMealThumb = selectedRecipe.strMealThumb
                        )
                    )
                }
            ) {
                Text("Add to Favorites")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Category: ${selectedRecipe.strCategory ?: "No category"}")
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = "Area: ${selectedRecipe.strArea ?: "Unknown"}")
            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = "Instructions:",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(text = selectedRecipe.strInstructions ?: "No instructions")

        } else {
            Text("No recipe selected")
        }

        Spacer(modifier = Modifier.height(24.dp))
    }
}