package dog.snow.androidrecruittest.repository.service

import dog.snow.androidrecruittest.repository.model.RawAlbum
import retrofit2.Call
import retrofit2.http.GET

interface AlbumService {

    @GET("albums")
    fun getAlbums(): Call<List<RawAlbum>>

    @GET("albums/id")
    fun getAlbumById(albumId: Int): RawAlbum {
        TODO("not implemented")
    }

}