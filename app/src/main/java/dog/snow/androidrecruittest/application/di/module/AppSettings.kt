package dog.snow.androidrecruittest.application.di.module

import android.content.SharedPreferences
import javax.inject.Inject

class AppSettings @Inject constructor(private val prefs: SharedPreferences)