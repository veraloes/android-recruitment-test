package dog.snow.androidrecruittest.feature.splashScreen

import dog.snow.androidrecruittest.application.base.BasePresenterInterface


interface SplashContract {

    interface View

    interface Presenter : BasePresenterInterface<View>
}