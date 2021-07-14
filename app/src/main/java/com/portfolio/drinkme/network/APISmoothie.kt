package com.portfolio.drinkme.network

import com.portfolio.drinkme.model.Category
import com.portfolio.drinkme.model.Smooth
import retrofit2.Call
import retrofit2.http.*

interface APISmoothie {

    @GET("categories.json")
    fun getCategories(): Call<MutableList<Category>>

    @GET("smoothies.json")
    fun getSmoothies(): Call<MutableList<Smooth>>

}