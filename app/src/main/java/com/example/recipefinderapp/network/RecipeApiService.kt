package com.example.recipefinderapp.network

import retrofit2.http.GET
import retrofit2.http.Query

interface RecipeApiService {

    @GET("search.php")
    suspend fun searchMeals(
        @Query("s") searchQuery: String
    ): RecipeResponse
}