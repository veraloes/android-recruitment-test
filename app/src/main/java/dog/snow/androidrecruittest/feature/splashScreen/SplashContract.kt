package dog.snow.androidrecruittest.feature.splashScreen

import dog.snow.androidrecruittest.application.base.BasePresenterInterface

interface SplashContract {

    interface View {
        fun goToMain()
        fun showError(errorMessage: String?)
    }

    interface Presenter : BasePresenterInterface<View> {
        fun fetchData()
        fun handleNoInternetConnection()
    }
}