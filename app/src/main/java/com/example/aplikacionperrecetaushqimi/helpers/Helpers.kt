package com.example.aplikacionperrecetaushqimi.helpers

import android.content.Context
import android.content.SharedPreferences
import com.example.aplikacionperrecetaushqimi.api.ServiceApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Helpers {


    fun provideRetrofit(): ServiceApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com/") // Replace with your API URL
            .build()
            .create(ServiceApi::class.java)
    }


    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("receta_ushqimi_prefs", Context.MODE_PRIVATE)
    }


    fun putIntToSharedPreferences(context: Context, key: String, value: Int) {
        provideSharedPreferences(context).edit().putInt(key, value).apply()
    }


    fun getIntFromSharedPreferences(context: Context, key: String): Int {
        return provideSharedPreferences(context).getInt(key, 0)
    }


    fun putStringToSharedPreferences(context: Context, key: String, value: String) {
        provideSharedPreferences(context).edit().putString(key, value).apply()
    }


    fun getStringFromSharedPreferences(context: Context, key: String): String? {
        return provideSharedPreferences(context).getString(key, null)
    }


    fun putBooleanToSharedPreferences(context: Context, key: String, value: Boolean) {
        provideSharedPreferences(context).edit().putBoolean(key, value).apply()
    }


    fun getBooleanFromSharedPreferences(context: Context, key: String): Boolean {
        return provideSharedPreferences(context).getBoolean(key, false)
    }
}
