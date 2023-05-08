package com.example.a0321app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_information.*

class Information : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)
        button1.setOnClickListener {
            var intent = Intent(this,histroy::class.java)
            startActivity(intent)
        }
        button2.setOnClickListener {
            var intent = Intent(this,introduce::class.java)
            startActivity(intent)
        }
        button3.setOnClickListener {
            var intent = Intent(this,traffic::class.java)
            startActivity(intent)
        }
        button4.setOnClickListener {
            var intent = Intent(this,ticket::class.java)
            startActivity(intent)
        }
        button5.setOnClickListener {
            var intent = Intent(this,videotest::class.java)
            startActivity(intent)
        }
    }
}