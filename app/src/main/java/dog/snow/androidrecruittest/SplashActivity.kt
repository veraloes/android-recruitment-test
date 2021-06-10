package dog.snow.androidrecruittest

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.layout_progressbar.*
import kotlinx.android.synthetic.main.splash_activity.*

class SplashActivity : AppCompatActivity(R.layout.splash_activity) {

    private var errorMessage: String = getString(R.string.offline_mode)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        checkInternetConnection()
    }

    private fun checkInternetConnection() {
        if (haveNetworkConnection()) {
            fetchData()
            initProgressBar()
        } else {
            showError(errorMessage)
        }
    }

    private fun fetchData() {
//        TODO(Download all the items)
        val topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        iv_logo_sd_text.startAnimation(bottomAnim)
        iv_logo_sd_symbol.startAnimation(topAnim)

        Handler().postDelayed(
            {
                goToMain()
            },
            SPLASH_DISPLAY_LENGTH
        )
    }

    private fun initProgressBar() {
        progressbar.isVisible = true
    }

    private fun goToMain() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun haveNetworkConnection(): Boolean {
        var haveConnectedWifi = false
        var haveConnectedMobile = false
        val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.allNetworkInfo
        for (ni in netInfo) {
            if (ni.typeName.equals(
                    "WIFI",
                    ignoreCase = true
                )
            ) if (ni.isConnected) haveConnectedWifi = true
            if (ni.typeName.equals(
                    "MOBILE",
                    ignoreCase = true
                )
            ) if (ni.isConnected) haveConnectedMobile = true
        }
        return haveConnectedWifi || haveConnectedMobile
    }

    private fun showError(errorMessage: String?) {
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.cant_download_dialog_title)
            .setMessage(getString(R.string.cant_download_dialog_message, errorMessage))
            .setPositiveButton(R.string.cant_download_dialog_btn_positive) { _, _ -> checkInternetConnection() }
            .setNegativeButton(R.string.cant_download_dialog_btn_negative) { _, _ -> finish() }
            .create()
            .apply { setCanceledOnTouchOutside(false) }
            .show()
    }

    companion object {
        private const val SPLASH_DISPLAY_LENGTH: Long = 4000
    }
}