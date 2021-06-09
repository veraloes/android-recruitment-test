package dog.snow.androidrecruittest

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.layout_progressbar.*

class SplashActivity : AppCompatActivity(R.layout.splash_activity) {

    private var networkStatus: Boolean = true
    private var errorMessage: String = "Error"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initProgressBar()
        checkNetworkConnection()
        fetchData()
    }

    private fun checkNetworkConnection() {
        if (networkStatus) {
            fetchData()
        } else {
            showError(errorMessage)
        }
    }

    private fun fetchData() {
//        TODO(Download all the items)

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

    private fun showError(errorMessage: String?) {
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.cant_download_dialog_title)
            .setMessage(getString(R.string.cant_download_dialog_message, errorMessage))
            .setPositiveButton(R.string.cant_download_dialog_btn_positive) { _, _ -> /*tryAgain()*/ }
            .setNegativeButton(R.string.cant_download_dialog_btn_negative) { _, _ -> finish() }
            .create()
            .apply { setCanceledOnTouchOutside(false) }
            .show()
    }

    companion object {
        private const val SPLASH_DISPLAY_LENGTH: Long = 4000
    }
}