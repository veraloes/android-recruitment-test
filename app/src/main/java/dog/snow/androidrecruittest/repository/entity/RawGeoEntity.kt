package dog.snow.androidrecruittest.repository.entity

import com.google.gson.annotations.SerializedName

data class RawGeo(
    @SerializedName("lat")
    val lat: String,
    @SerializedName("lng")
    val lng: String
)