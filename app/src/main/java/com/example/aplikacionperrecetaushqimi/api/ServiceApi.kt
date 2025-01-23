package com.example.aplikacionperrecetaushqimi.api

import retrofit2.Call
import com.example.aplikacionperrecetaushqimi.model.Recipe
import retrofit2.http.GET
import retrofit2.http.Path

interface ServiceApi {

    @GET("recipes")
    fun getRecipes(): Call<List<Recipe>>

    @GET("recipes/{id}")
    fun getRecipeById(@Path("id") id: Int): Call<Recipe>
}
