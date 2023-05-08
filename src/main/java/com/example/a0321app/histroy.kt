package com.example.a0321app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_histroy.*

class histroy : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_histroy)
        webview1.loadUrl("file:///android_asset/羅浮宮歷史.htm")
    }
}