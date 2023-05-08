package com.example.a0321app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.MovementMethod
import android.text.method.ScrollingMovementMethod
import kotlinx.android.synthetic.main.activity_traffic.*

class traffic : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_traffic)

        var inputstream = baseContext.assets.open("交通方式.txt")
        textview1.text = inputstream.bufferedReader().use { it.readText() }
        textview1.movementMethod = ScrollingMovementMethod()
    }
}