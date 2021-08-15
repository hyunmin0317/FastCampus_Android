package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_resource.*

class Resource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        // 1
        val ment = resources.getString(R.string.hello)
        Log.d("mentt", "ment : "+ment)

        // 2
        val ment2 = resources.getString(R.string.hello)
        Log.d("mentt", "ment : "+ment2)

        val color = getColor(R.color.textview_color)
        Log.d("mentt", "color : "+color)

        button.setBackgroundColor(getColor(R.color.textview_color))
    }
}