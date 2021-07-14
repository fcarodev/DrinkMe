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
    lateinit var presenter: SplashPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = SplashPresenter(this)
        presenter.onCreate()


    }
    fun goToHome(){
        val intent =
            Intent(this, HomeActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
        goToActivityAnimation()
        finish()
    }
}



