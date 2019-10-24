package com.israel.app.miadaptador

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    val adapter = MediaAdapter { navigateToDetail(it) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.adapter = adapter

        MediaProvider.dataAsync { adapter.items = it }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val filter: Filter = when (item.itemId) {
            R.id.filter_photos -> Filter.ByType(MediaItem.Type.PHOTO)
            R.id.filter_videos -> Filter.ByType(MediaItem.Type.VIDEO)
            else -> Filter.None
        }

        loadFilteredData(filter)
        /*MediaProvider.dataAsync { media ->
            adapter.items = when (item.itemId) {
                R.id.filter_all -> media
                R.id.filter_photos ->media.filter { it.type == MediaItem.Type.PHOTO }
                R.id.filter_videos ->media.filter { it.type == MediaItem.Type.VIDEO }
                else -> emptyList()
            }

        }*/
        return true
    }

    private fun loadFilteredData(filter: Filter) {
        MediaProvider.dataAsync { media ->
            adapter.items = when (filter) {
                Filter.None -> media
                is Filter.ByType -> media.filter { it.type == filter.type }
            }
        }
    }

    private fun navigateToDetail(item: MediaItem) {
        startActivity<DetailActivity>(DetailActivity.ID to item.id)
    }

    sealed class Filter {
        object None : Filter()
        class ByType(val type: MediaItem.Type) : Filter()
    }
}
