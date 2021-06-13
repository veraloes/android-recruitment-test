package dog.snow.androidrecruittest.repository.entity

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class RawUser(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("address")
    val address: RawAddress,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("website")
    val website: String,
    @SerializedName("company")
    val company: RawCompany
)
