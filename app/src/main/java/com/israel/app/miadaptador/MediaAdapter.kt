package com.israel.app.miadaptador

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.israel.app.miadaptador.MediaItem.Type

class MediaAdapter(val items: List<MediaItem>): RecyclerView.Adapter<MediaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        //val v = LayoutInflater.from(parent.context).inflate(R.layout.view_media_item, parent, false)
        val v = parent.inflate(R.layout.view_media_item)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

    class ViewHolder(view : View) :RecyclerView.ViewHolder(view) {
        //val title = view.findViewById(R.id.media_title) as TextView
        val title = find<TextView>(R.id.media_title)
        val image = find<ImageView>(R.id.image)
        val videoIndicator = find<ImageView>(R.id.media_video_indicator)

        fun bind(item: MediaItem){
            title.text = item.title
            image.loadUrl(item.url)
            videoIndicator.visibility = when (item.type) {
                Type.PHOTO -> GONE
                Type.VIDEO -> VISIBLE
                else -> GONE
            }
        }
    }

}