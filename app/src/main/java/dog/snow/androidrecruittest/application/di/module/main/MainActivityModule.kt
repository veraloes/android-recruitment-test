package dog.snow.androidrecruittest.application.di.module.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dog.snow.androidrecruittest.application.PresenterKey
import dog.snow.androidrecruittest.feature.main.MainPresenter

@Module
abstract class MainActivityModule {
    @Binds
    @IntoMap
    @PresenterKey(MainPresenter::class)
    abstract fun bindMainActivityViewModel(presenter: MainPresenter): ViewModel

}