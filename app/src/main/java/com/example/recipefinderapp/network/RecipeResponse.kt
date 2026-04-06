package com.example.recipefinderapp.network

data class RecipeResponse(
    val meals: List<Meal>?
)

data class Meal(
    val idMeal: String,
    val strMeal: String,
    val strCategory: String?,
    val strArea: String?,
    val strInstructions: String?,
    val strMealThumb: String?
)