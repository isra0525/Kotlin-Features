package com.israel.app.miadaptador

import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

object MediaProvider {
    private val thumbBase = "http://lorempixel.com/400/400/cats/"

    fun dataAsync (callback: (List<MediaItem>) -> Unit) {
        doAsync {
            Thread.sleep(2000)
            val items =(1..10).map {
                MediaItem(it,"Title $it", "$thumbBase$it", if (it % 3 == 0) MediaItem.Type.VIDEO else MediaItem.Type.PHOTO)
            }

            uiThread {
                callback(items)
            }
        }
    }
}