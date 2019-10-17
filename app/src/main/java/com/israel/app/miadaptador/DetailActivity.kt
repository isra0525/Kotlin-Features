package com.israel.app.miadaptador

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.doAsync

class DetailActivity : AppCompatActivity() {

    companion object {
        val ID = "DetailActivity:id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val ud = intent.getIntExtra(ID, -1)

        MediaProvider.dataAsync { media ->
            val item = media.find {it.id == id}

        }
    }
}
