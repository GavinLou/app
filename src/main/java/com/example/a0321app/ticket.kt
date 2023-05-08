package com.example.a0321app

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_ticket.*
import kotlinx.android.synthetic.main.ticketlayout.view.*
import org.json.JSONArray

class ticket : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket)

        var inputStream = baseContext.assets.open("票價.json")
        var jsonArray = JSONArray(inputStream.bufferedReader().use { it.readText() })
        var adapter = layout(this,jsonArray)
        listview1.adapter = adapter
    }
}

class layout(var context: Context , var data : JSONArray) : BaseAdapter(){
    override fun getCount(): Int {
        return  data.length()
    }
    override fun getItem(p0: Int): Any {
        return p0
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.ticketlayout , p2 , false)
        view.textview1.text = data.getJSONObject(p0).getString("Type")
        view.textview2.text = data.getJSONObject(p0).getString("Money")
        return view
    }
}