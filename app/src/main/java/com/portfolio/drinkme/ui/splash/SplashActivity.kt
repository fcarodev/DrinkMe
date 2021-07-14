package com.portfolio.drinkme.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.orhanobut.logger.Logger
import com.portfolio.drinkme.R
import com.portfolio.drinkme.manager.HawkManager
import com.portfolio.drinkme.model.Category
import com.portfolio.drinkme.model.Smooth
import com.portfolio.drinkme.network.RestClientSmoothie
import com.portfolio.drinkme.ui.home.HomeActivity
import com.portfolio.drinkme.utils.extentions.goToActivityAnimation
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // goToHome()
        RestClientSmoothie().get()?.getCategories()?.enqueue(object : Callback<MutableList<Category>>{
            override fun onResponse(
                call: Call<MutableList<Category>>,
                response: Response<MutableList<Category>>
            ) {
                if (response.isSuccessful){
                    HawkManager().setCategoryList(response.body()!!)
                    Logger.i(Gson().toJson(HawkManager().getCategoryList()))
                }
            }

            override fun onFailure(call: Call<MutableList<Category>>, t: Throwable) {
                Logger.i(t.message.toString())
            }
        })

        RestClientSmoothie().get()?.getSmoothies()?.enqueue(object : Callback<MutableList<Smooth>>{
            override fun onResponse(
                call: Call<MutableList<Smooth>>,
                response: Response<MutableList<Smooth>>
            ) {
                Logger.i(Gson().toJson( response.body()))
            }

            override fun onFailure(call: Call<MutableList<Smooth>>, t: Throwable) {
                Logger.i(t.message.toString())

            }
        })
    }
    fun goToHome(){
        val intent =
            Intent(this, HomeActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        goToActivityAnimation()
        finish()
    }
}



