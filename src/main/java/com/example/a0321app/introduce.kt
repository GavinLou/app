package com.example.a0321app

import android.graphics.BitmapFactory
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_information.*
import kotlinx.android.synthetic.main.activity_information.button1
import kotlinx.android.synthetic.main.activity_information.button2
import kotlinx.android.synthetic.main.activity_information.button3
import kotlinx.android.synthetic.main.activity_information.button4
import kotlinx.android.synthetic.main.activity_information.button5
import kotlinx.android.synthetic.main.activity_introduce.*

class introduce : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduce)
        var inputStream = assets.open("open.jpg")
        image1.setImageBitmap(BitmapFactory.decodeStream(inputStream))
        var buttons = arrayOf(button1,button2,button3,button4,button5)
        buttons.forEachIndexed { index, button -> button.setOnClickListener {changeimage(index)  } }
    }
    fun changeimage(i : Int){
        var buttons = arrayOf(button1,button2,button3,button4,button5)
        var string = arrayOf("B2F.jpg","B1F.jpg","0F.jpg","1F.jpg","2F.jpg")
        var inputStream = assets.open(string[i])
        image1.setImageBitmap(BitmapFactory.decodeStream(inputStream))
        buttons.forEachIndexed { index, button -> button.paintFlags = if(index == i) Paint.UNDERLINE_TEXT_FLAG else 0 }
    }
}