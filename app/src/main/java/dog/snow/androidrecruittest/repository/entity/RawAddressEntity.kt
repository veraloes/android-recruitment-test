package dog.snow.androidrecruittest.repository.entity

import com.google.gson.annotations.SerializedName

data class RawAddress(
    @SerializedName("street")
    val street: String,
    @SerializedName("suite")
    val suite: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("zipcode")
    val zipcode: String,
    @SerializedName("geo")
    val geo: RawGeo
)