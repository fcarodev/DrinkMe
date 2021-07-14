package com.portfolio.drinkme.ui.splash

import android.app.Activity
import android.content.Intent
import com.portfolio.drinkme.ui.home.HomeActivity
import com.portfolio.drinkme.ui.login.LoginActivity
import com.portfolio.drinkme.utils.extentions.goToActivityAnimation

class SplashRouter constructor(private val activity: Activity):SplashContract.Router {

    override fun navigateHome() {
        val intent = Intent(activity, HomeActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        activity.startActivity(intent)
        activity.goToActivityAnimation()
        activity.finish()
    }

    override fun navigateLogin() {
        val intent = Intent(activity, LoginActivity::class.java).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        activity.startActivity(intent)
        activity.goToActivityAnimation()
        activity.finish()
    }
}