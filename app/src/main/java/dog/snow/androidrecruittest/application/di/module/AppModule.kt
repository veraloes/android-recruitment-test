package dog.snow.androidrecruittest.application.di.module

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dog.snow.androidrecruittest.application.App
import dog.snow.androidrecruittest.application.ThreadManager
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Module
    companion object {
        @Provides
        @Singleton
        @JvmStatic
        fun provideAppContext(app: App): Context =
            app.applicationContext

        @Provides
        @Singleton
        @JvmStatic
        fun provideSharedPreferences(context: Context): SharedPreferences =
            context.getSharedPreferences(PREFS_FILENAME, Context.MODE_PRIVATE)

        @Provides
        @Singleton
        @JvmStatic
        fun provideAppSettings(sharedPreferences: SharedPreferences) =
            AppSettings(sharedPreferences)

        @Provides
        @Singleton
        @JvmStatic
        fun provideThreadManager() =
            ThreadManager()

        private const val PREFS_FILENAME = "dog.snow.androidrecruittest.prefs"

    }
}