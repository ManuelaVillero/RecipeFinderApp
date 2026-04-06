package com.example.recipefinderapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipefinderapp.data.FavoriteRecipe
import com.example.recipefinderapp.data.RecipeRepository
import com.example.recipefinderapp.network.Meal
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RecipeViewModel(
    private val repository: RecipeRepository
) : ViewModel() {

    private val _recipes = MutableStateFlow<List<Meal>>(emptyList())
    val recipes: StateFlow<List<Meal>> = _recipes

    val favorites = repository.getAllFavorites()

    fun search(query: String) {
        viewModelScope.launch {
            _recipes.value = repository.searchRecipes(query)
        }
    }

    fun addFavorite(recipe: FavoriteRecipe) {
        viewModelScope.launch {
            repository.insertFavorite(recipe)
        }
    }

    fun deleteFavorite(id: String) {
        viewModelScope.launch {
            repository.deleteFavorite(id)
        }
    }
}