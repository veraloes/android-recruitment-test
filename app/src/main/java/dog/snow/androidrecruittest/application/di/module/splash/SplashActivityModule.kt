package dog.snow.androidrecruittest.application.di.module.splash

import androidx.lifecycle.ViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dog.snow.androidrecruittest.application.PresenterKey
import dog.snow.androidrecruittest.feature.splashScreen.SplashPresenter

@Module
abstract class SplashActivityModule {
    @Binds
    @IntoMap
    @PresenterKey(SplashPresenter::class)
    abstract fun bindSplashPresenter(presenter: SplashPresenter): ViewModel


}