package com.portfolio.drinkme.ui.splash

import android.app.Activity
import java.util.*

class SplashPresenter(private val activity:Activity):SplashContract.Presenter,SplashContract.InteractorOutput {

    private var mInteractor: SplashContract.Interactor = SplashInteractor(this)
    private var mView: SplashContract.View = activity as SplashContract.View
    private var mRouter: SplashContract.Router = SplashRouter(activity)

    override fun onCreate() {
        mView.startAnimation()
        mInteractor.getSmoothies()
    }

    override fun onSuccessGetCategories() {
        TODO("Not yet implemented")
    }

    override fun onErrorGetCategories(msg:String) {
        mView.showErrorMessage(msg)
    }

    override fun onSuccessGetSmoothies() {
        mInteractor.getCategories()
    }

    override fun onErrorGetSmoothies(msg:String) {
        mView.showErrorMessage(msg)
    }
}