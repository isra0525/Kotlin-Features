package com.israel.app.miadaptador

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.adapter = MediaAdapter(getMedia()) { mediaItem -> toast(mediaItem.title) }

        val myLazyVal  by lazy { Log.d("","")}
    }
}
