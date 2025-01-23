package com.example.aplikacionperrecetaushqimi.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.aplikacionperrecetaushqimi.helpers.Helpers.provideRetrofit
import com.example.aplikacionperrecetaushqimi.model.Recipe
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RecipeViewModel : ViewModel() {
    private var _recipeList: MutableLiveData<List<Recipe>> = MutableLiveData(mutableListOf())
    val recipeList: MutableLiveData<List<Recipe>>
        get() = _recipeList

    var loading = MutableLiveData<Boolean>()

    fun getRecipes() {
        loading.value = true
        provideRetrofit().getRecipes().enqueue(object : Callback<List<Recipe>> {
            override fun onResponse(call: Call<List<Recipe>>, response: Response<List<Recipe>>) {
                if (response.isSuccessful && response.body() != null) {
                    _recipeList.value = response.body()
                }
                loading.value = false
            }

            override fun onFailure(call: Call<List<Recipe>>, t: Throwable) {
                loading.value = false
            }
        })
    }
}
