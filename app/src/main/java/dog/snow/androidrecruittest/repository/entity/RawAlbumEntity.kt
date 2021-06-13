package dog.snow.androidrecruittest.repository.entity

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class RawAlbumEntity(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("title")
    val title: String
)