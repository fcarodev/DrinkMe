package com.portfolio.drinkme.ui.splash

interface SplashContract {

    interface View {
        fun showErrorMessage(errorMsg: String)
        fun showMessage(msg: String)
        fun startAnimation()
        fun stopAnimation()
    }

    interface Presenter {
        fun onCreate()
    }

    interface Interactor {
        fun getCategories()
        fun getSmoothies()
    }

    interface InteractorOutput {
        fun onSuccessGetCategories()
        fun onErrorGetCategories(msg:String)

        fun onSuccessGetSmoothies()
        fun onErrorGetSmoothies(msg:String)
    }

    interface Router {
        fun navigateHome()
        fun navigateLogin()
    }

}