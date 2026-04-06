package com.example.recipefinderapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.recipefinderapp.navigation.Screen
import com.example.recipefinderapp.viewmodel.RecipeViewModel

@Composable
fun SearchScreen(navController: NavController, viewModel: RecipeViewModel) {
    var query by remember { mutableStateOf("") }
    val recipes by viewModel.recipes.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Recipe Finder", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = query,
            onValueChange = { query = it },
            label = { Text("Search recipe") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { viewModel.search(query) }) {
            Text("Search")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = { navController.navigate(Screen.Favorites.route) }) {
            Text("Go to Favorites")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(recipes) { meal ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    onClick = {
                        navController.navigate(Screen.Details.route)
                    }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = meal.strMeal,
                            style = MaterialTheme.typography.titleMedium
                        )
                        Text(text = meal.strCategory ?: "No category")
                    }
                }
            }
        }
    }
}