package com.portfolio.drinkme.ui.splash

import com.google.gson.Gson
import com.orhanobut.logger.Logger
import com.portfolio.drinkme.manager.HawkManager
import com.portfolio.drinkme.model.Category
import com.portfolio.drinkme.model.Smooth
import com.portfolio.drinkme.network.RestClientSmoothie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashInteractor(private val output:SplashContract.InteractorOutput):SplashContract.Interactor {

    override fun getCategories() {
        RestClientSmoothie().get()?.getCategories()?.enqueue(object : Callback<MutableList<Category>>{
            override fun onResponse(
                call: Call<MutableList<Category>>,
                response: Response<MutableList<Category>>
            ) {
                if (response.isSuccessful){
                    HawkManager().setCategoryList(response.body()!!)
                    Logger.i(Gson().toJson(HawkManager().getCategoryList()))
                    output.onSuccessGetCategories()
                }else{
                    output.onErrorGetCategories("Error getting categories: ${response.code()}")
                }
            }
            override fun onFailure(call: Call<MutableList<Category>>, t: Throwable) {
                Logger.i(t.message.toString())
                output.onErrorGetCategories("Error getting categories: ${t.message}")
            }
        })
    }

    override fun getSmoothies() {
        RestClientSmoothie().get()?.getSmoothies()?.enqueue(object : Callback<MutableList<Smooth>>{
            override fun onResponse(
                call: Call<MutableList<Smooth>>,
                response: Response<MutableList<Smooth>>
            ) {
                if (response.isSuccessful){
                    Logger.i(Gson().toJson( response.body()))
                    output.onSuccessGetSmoothies()
                }
                else{
                    output.onErrorGetCategories("Error getting categories: ${response.code()}")
                }

            }

            override fun onFailure(call: Call<MutableList<Smooth>>, t: Throwable) {
                Logger.i(t.message.toString())
                output.onErrorGetCategories("Error getting categories: ${t.message}")
            }
        })

    }
}