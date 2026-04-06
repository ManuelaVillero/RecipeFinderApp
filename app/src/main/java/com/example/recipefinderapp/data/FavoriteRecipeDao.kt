package com.example.recipefinderapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteRecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(recipe: FavoriteRecipe)

    @Query("SELECT * FROM favorite_recipes")
    fun getAllFavorites(): Flow<List<FavoriteRecipe>>

    @Query("DELETE FROM favorite_recipes WHERE idMeal = :id")
    suspend fun delete(id: String)
}