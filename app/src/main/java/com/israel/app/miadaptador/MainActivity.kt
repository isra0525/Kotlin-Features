package com.israel.app.miadaptador

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val adapter = MediaAdapter(MediaProvider.data) { mediaItem -> toast(mediaItem.title) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.adapter = adapter

        val myLazyVal  by lazy { Log.d("","")}
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        adapter.items = MediaProvider.data.let { media ->
            when (item.itemId) {
                R.id.filter_all -> media
                R.id.filter_photos ->media.filter { it.type == MediaItem.Type.PHOTO }
                R.id.filter_videos ->media.filter { it.type == MediaItem.Type.VIDEO }

                else -> emptyList()
            }

        }
        return true
    }
}
