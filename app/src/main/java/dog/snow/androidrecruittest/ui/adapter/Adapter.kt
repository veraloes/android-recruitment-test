package dog.snow.androidrecruittest.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import dog.snow.androidrecruittest.R
import dog.snow.androidrecruittest.repository.model.RawPhoto

class Adapter(private val photos: List<RawPhoto>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivThumb: ImageView = itemView.findViewById(R.id.iv_thumb)
        val tvPhotoTitle: TextView = itemView.findViewById(R.id.tv_photo_title)
        val tvAlbumTitle: TextView = itemView.findViewById(R.id.tv_album_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = photos[position]
        Picasso.get().load(photos[position].thumbnailUrl).into(holder.ivThumb)
        holder.tvAlbumTitle.text = photo.albumId.toString()
        holder.tvPhotoTitle.text = photo.title
        holder.itemView.tag = position
    }

    override fun getItemCount(): Int {
        return photos.size
    }
}