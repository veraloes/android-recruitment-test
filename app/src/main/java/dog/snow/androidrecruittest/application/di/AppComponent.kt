package dog.snow.androidrecruittest.application.di


import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dog.snow.androidrecruittest.application.App
import dog.snow.androidrecruittest.application.PresenterFactoryBuilder
import dog.snow.androidrecruittest.application.di.module.ActivityBuilderModule
import dog.snow.androidrecruittest.application.di.module.AppModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilderModule::class,
        PresenterFactoryBuilder::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}