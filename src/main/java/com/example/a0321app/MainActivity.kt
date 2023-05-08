package com.example.a0321app

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AlertDialog.Builder(this)
            .setMessage("eeddde")
            .setTitle("sdsdvdee")
            .setPositiveButton("OK", DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(
                    this,
                    "eeeeeeeeeeee",
                    Toast.LENGTH_SHORT
                ).show() })
            .show()
        button1.setOnClickListener {
            var intent = Intent(this,Information::class.java)
            startActivity(intent)

        }
        button4.setOnClickListener {
            var intent = Intent(this,Feedback::class.java)
            startActivity(intent)
        }
    }
}