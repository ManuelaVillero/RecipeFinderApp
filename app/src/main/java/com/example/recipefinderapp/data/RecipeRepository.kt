package com.example.recipefinderapp.data

import com.example.recipefinderapp.network.Meal
import com.example.recipefinderapp.network.RetrofitInstance
import kotlinx.coroutines.flow.Flow

class RecipeRepository(
    private val dao: FavoriteRecipeDao? = null
) {

    suspend fun searchRecipes(query: String): List<Meal> {
        return RetrofitInstance.api.searchMeals(query).meals ?: emptyList()
    }

    suspend fun insertFavorite(recipe: FavoriteRecipe) {
        dao?.insert(recipe)
    }

    fun getAllFavorites(): Flow<List<FavoriteRecipe>> {
        return dao?.getAllFavorites() ?: kotlinx.coroutines.flow.flowOf(emptyList())
    }

    suspend fun deleteFavorite(id: String) {
        dao?.delete(id)
    }
}