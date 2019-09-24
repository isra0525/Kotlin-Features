package com.israel.app.miadaptador

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class MediaAdapter(val items: List<MediaItem>): RecyclerView.Adapter<MediaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.view_media_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

    class ViewHolder(view : View) :RecyclerView.ViewHolder(view) {
        val title = view.findViewById(R.id.media_title) as TextView
        val image = view.findViewById(R.id.image) as ImageView
        fun bind(item: MediaItem){
            title.text = item.title
            Picasso.with(image.context).load(item.url).into(image)
        }
    }

}