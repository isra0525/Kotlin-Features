package com.israel.app.miadaptador

fun doAsync(x: Int, callBack: (String) -> Unit) {
    callBack.invoke("Finished")
}

fun test(items: List<MediaItem>) {
    val urlList: List<String> = items
        .filter { it.type == MediaItem.Type.PHOTO }
        .sortedBy { it.title }
        .map { it.url }
}