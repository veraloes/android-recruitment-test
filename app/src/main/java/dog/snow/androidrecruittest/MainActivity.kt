package dog.snow.androidrecruittest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import dog.snow.androidrecruittest.repository.model.RawPhoto
import dog.snow.androidrecruittest.repository.service.PhotoService
import dog.snow.androidrecruittest.ui.adapter.Adapter
import kotlinx.android.synthetic.main.layout_empty_view.*
import kotlinx.android.synthetic.main.list_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(R.layout.main_activity) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(findViewById(R.id.toolbar))

        initializeRetrofit()
    }

    private fun initializeRetrofit() {
        val apiBaseUrl = "https://jsonplaceholder.typicode.com/"

        val retrofit = Retrofit.Builder()
            .baseUrl(apiBaseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()

        val api = retrofit.create(PhotoService::class.java)
        api.getPhotos().enqueue(object : Callback<List<RawPhoto>> {

            override fun onResponse(
                call: Call<List<RawPhoto>>,
                response: Response<List<RawPhoto>>
            ) {
                Log.d("plant", "onResponse")
                showData(response.body()!!)
            }

            override fun onFailure(call: Call<List<RawPhoto>>, t: Throwable) {
                Log.d("plant", "onFail")
                tv_empty.isVisible = true
            }
        })
    }

    private fun showData(plants: List<RawPhoto>) {
        // TODO: 6/10/21  Change visibility of +id/tv_empty if url is incorrect

        rv_items.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = Adapter(plants)
        }
    }

    override fun onBackPressed() {
        Log.d("backButton", "pressed")
    }
}