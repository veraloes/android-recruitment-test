package dog.snow.androidrecruittest.feature.main

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.application.base.BaseActivity
import dog.snow.androidrecruittest.repository.model.RawPhoto
import dog.snow.androidrecruittest.repository.service.PhotoService
import dog.snow.androidrecruittest.ui.adapter.Adapter
import kotlinx.android.synthetic.main.layout_empty_view.*
import kotlinx.android.synthetic.main.list_fragment.*
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : BaseActivity(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setSupportActionBar(findViewById(R.id.toolbar))

        initializeRetrofit()
    }

    private fun initializeRetrofit() {
        val apiBaseUrl = "https://jsonplaceholder.typicode.com/"
        val cacheSize = (10 * 1024 * 1024).toLong()
        val myCache = Cache(this.cacheDir, cacheSize)

        val okHttpClient = OkHttpClient.Builder()
            .cache(myCache)
            .addInterceptor { chain ->
                var request = chain.request()
                request = if (hasNetwork(this)!!)
                    request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                else
                    request.newBuilder().header(
                        "Cache-Control",
                        "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7
                    ).build()
                chain.proceed(request)
            }
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(apiBaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        val api = retrofit.create(PhotoService::class.java)
        api.getPhotos().enqueue(object : Callback<List<RawPhoto>> {

            override fun onResponse(
                call: Call<List<RawPhoto>>,
                response: Response<List<RawPhoto>>
            ) {
                Log.d("API", "onResponse")
                showData(response.body()!!)
            }

            override fun onFailure(call: Call<List<RawPhoto>>, t: Throwable) {
                Log.d("API", "onFail")
                tv_empty.isVisible = true
            }
        })
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

    override fun showData(list: List<RawPhoto>) {

        rv_items.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = Adapter(list)
        }
    }

    override fun onBackPressed() {
        Log.d("backButton", "pressed")
    }
}