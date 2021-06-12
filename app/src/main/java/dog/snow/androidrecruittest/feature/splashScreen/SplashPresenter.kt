package dog.snow.androidrecruittest.feature.splashScreen

import android.os.Handler
import dog.snow.androidrecruittest.application.base.BasePresenter
import javax.inject.Inject

class SplashPresenter @Inject constructor(
) : BasePresenter<SplashContract.View>(),
    SplashContract.Presenter {

    override fun fetchData() {
//        TODO(Download all items on Splash Screen)

        Handler().postDelayed(
            {
                getScreen()?.goToMain()
            },
            SPLASH_DISPLAY_LENGTH
        )
    }

    override fun handleNoInternetConnection() {
        getScreen()?.showError(errorMessage = "error")
    }

    companion object {
        private const val SPLASH_DISPLAY_LENGTH: Long = 4000
    }
}