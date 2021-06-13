package dog.snow.androidrecruittest.repository.entity

import com.google.gson.annotations.SerializedName


data class RawCompany(
    @SerializedName("name")
    val name: String,
    @SerializedName("catch_phrase")
    val catchPhrase: String,
    @SerializedName("bs")
    val bs: String
)
