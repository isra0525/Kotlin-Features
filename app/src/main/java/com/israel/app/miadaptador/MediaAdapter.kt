package com.israel.app.miadaptador

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.israel.app.miadaptador.MediaItem.Type
import kotlinx.android.synthetic.main.view_media_item.view.*
import kotlin.properties.Delegates

class MediaAdapter(val listener: (MediaItem) -> Unit)
    : RecyclerView.Adapter<MediaAdapter.ViewHolder>() {

    var items: List<MediaItem> by Delegates.observable(items){ _, _, _->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val v = parent.inflate(R.layout.view_media_item)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item)}
    }

    class ViewHolder(view : View) :RecyclerView.ViewHolder(view) {
        fun bind(item: MediaItem){

            with(itemView){
                media_title.text = item.title
                print(item.url)
                media_thumb.loadUrl(item.url)
                media_video_indicator.visibility = when (item.type) {
                    Type.PHOTO -> GONE
                    Type.VIDEO -> VISIBLE
                    else -> VISIBLE
                }
            }
        }
    }

}