package com.example.a0321app

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Spinner
import android.widget.Toast
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_feedback.*
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URI
import java.net.URL
import java.time.Duration
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import kotlin.concurrent.thread

class Feedback : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feedback)
        button1.isEnabled = false
        var token : String? = null
        thread {
                var data = JSONObject(URL("http://192.168.0.104/RegisterToken").readText())
                token = data.getString("guid")
                var tetst = LocalDateTime.now(ZoneId.of("Asia/Taipei"))

                var a = LocalDateTime.parse(data.getString("responceTime"), DateTimeFormatter.ISO_DATE_TIME)
            var s = Duration.between(a ,LocalDateTime.now()).seconds
            while (Duration.between(a ,LocalDateTime.now()).seconds < 0){
                println(LocalDateTime.now())
                runOnUiThread {
                    button1.text = Duration.between(a ,LocalDateTime.now()).seconds.toString()
                }
            }
            runOnUiThread {
                button1.text = "提交意見"
                button1.isEnabled = true
            }
        }

        button1.setOnClickListener {
            var JSONObject = JSONObject()
            JSONObject.put("guid", token)
            JSONObject.put("text",token)
            JSONObject.put("star",ratingbar1.rating.toInt())
            thread {
                var s = Post("http://192.168.0.104/SendResult" , JSONObject)
                runOnUiThread {
                    Toast.makeText(this, s , Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    fun Post(url : String ,data : JSONObject) : String{
        var con = URL(url).openConnection() as HttpURLConnection
        con.requestMethod = "POST"
        con.setRequestProperty("Content-type" , "application/json")
        con.outputStream.bufferedWriter().use { it.write(data.toString()) }
        if(con.responseCode == HttpURLConnection.HTTP_BAD_REQUEST){
            runOnUiThread {
                Toast.makeText(this@Feedback, JSONObject(con.errorStream.bufferedReader().use { it.readText() }).getString("Message"), Toast.LENGTH_SHORT).show()
            }
        }
        return con.inputStream.bufferedReader().use { it.readText() }
    }
}