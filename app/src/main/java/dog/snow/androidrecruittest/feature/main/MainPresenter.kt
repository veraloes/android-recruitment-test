package dog.snow.androidrecruittest.feature.main

import dog.snow.androidrecruittest.application.base.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor() : BasePresenter<MainContract.View>(),
    MainContract.Presenter