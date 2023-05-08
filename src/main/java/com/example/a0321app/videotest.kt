package com.example.a0321app

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_videotest.*

class videotest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videotest)
        var mediaController : MediaController? = null

        if(mediaController == null){
            mediaController = MediaController(this)
            mediaController.setAnchorView(this.media1)
        }
        media1!!.setMediaController(null)
        media1!!.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + R.raw.test))
        media1!!.requestFocus()
        media1!!.start()
    }
}