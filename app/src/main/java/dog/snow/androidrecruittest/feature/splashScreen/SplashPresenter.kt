package dog.snow.androidrecruittest.feature.splashScreen

import dog.snow.androidrecruittest.application.base.BasePresenter
import javax.inject.Inject

class SplashPresenter @Inject constructor(
) : BasePresenter<SplashContract.View>(),
    SplashContract.Presenter