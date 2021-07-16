package com.portfolio.drinkme.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.portfolio.drinkme.R


class SplashActivity : AppCompatActivity(),SplashContract.View {
    lateinit var presenter: SplashPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = SplashPresenter(this)
        presenter.onCreate()


    }

    override fun showErrorMessage(errorMsg: String) {
        Toast.makeText(this,errorMsg,Toast.LENGTH_LONG).show()
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }

    override fun startAnimation() {

    }

    override fun stopAnimation() {

    }
}



