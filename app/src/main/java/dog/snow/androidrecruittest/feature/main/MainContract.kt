package dog.snow.androidrecruittest.feature.main

import dog.snow.androidrecruittest.application.base.BasePresenterInterface

interface MainContract {
    interface View

    interface Presenter : BasePresenterInterface<View>
}