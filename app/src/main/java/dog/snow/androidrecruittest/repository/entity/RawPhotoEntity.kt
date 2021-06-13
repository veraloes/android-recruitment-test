package dog.snow.androidrecruittest.repository.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "raw_photo_table")
data class RawPhotoEntity(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("album_id")
    val albumId: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String
)