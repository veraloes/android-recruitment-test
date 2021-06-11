package dog.snow.androidrecruittest.application.di.module


import dagger.Module
import dagger.android.ContributesAndroidInjector
import dog.snow.androidrecruittest.application.di.module.main.MainActivityModule
import dog.snow.androidrecruittest.application.di.module.splash.SplashActivityModule
import dog.snow.androidrecruittest.feature.main.MainActivity
import dog.snow.androidrecruittest.feature.splashScreen.SplashActivity

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [SplashActivityModule::class])
    abstract fun splashActivity(): SplashActivity
}