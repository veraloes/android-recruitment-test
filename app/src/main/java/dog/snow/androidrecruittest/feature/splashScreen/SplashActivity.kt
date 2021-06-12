package dog.snow.androidrecruittest.feature.splashScreen

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.application.ThreadManager
import dog.snow.androidrecruittest.application.base.BaseActivity
import dog.snow.androidrecruittest.feature.main.MainActivity
import kotlinx.android.synthetic.main.layout_progressbar.*
import kotlinx.android.synthetic.main.splash_activity.*
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashContract.View {

    @Inject
    lateinit var presenterFactory: ViewModelProvider.Factory

    @Inject
    lateinit var threadManager: ThreadManager
    private lateinit var presenter: SplashContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView((R.layout.splash_activity))

        presenter =
            ViewModelProvider(this, presenterFactory).get(SplashPresenter::class.java)
        presenter.attach(this)

        checkInternetConnection()

        threadManager.backThread.execute {
            val topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
            val bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)
            iv_logo_sd_text.startAnimation(bottomAnim)
            iv_logo_sd_symbol.startAnimation(topAnim)
        }
    }

    private fun hasNetwork(context: Context): Boolean? {
        var isConnected: Boolean? = false // Initial Value
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }

    private fun checkInternetConnection() {
        if (hasNetwork(this) == true) {
            presenter.fetchData()
            initProgressBar()
        } else {
            presenter.handleNoInternetConnection()
        }
    }

    private fun initProgressBar() {
        progressbar.isVisible = true
    }

    override fun goToMain() {
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun showError(errorMessage: String?) {
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.cant_download_dialog_title)
            .setMessage(getString(R.string.cant_download_dialog_message, errorMessage))
            .setPositiveButton(R.string.cant_download_dialog_btn_positive) { _, _ -> checkInternetConnection() }
            .setNegativeButton(R.string.cant_download_dialog_btn_negative) { _, _ -> finish() }
            .create()
            .apply { setCanceledOnTouchOutside(false) }
            .show()
    }
}