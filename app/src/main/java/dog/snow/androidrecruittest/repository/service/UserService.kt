package dog.snow.androidrecruittest.repository.service

import dog.snow.androidrecruittest.repository.model.RawUser
import retrofit2.Call
import retrofit2.http.GET

interface UserService {

    @GET("users")
    fun getUsers(): Call<List<RawUser>>

    @GET("user/id")
    fun getUserById(photoId: Int): RawUser {
        TODO("not implemented")
    }

}