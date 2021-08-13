package com.example.fastcampus_android

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fastcampus_android.BuildConfig.VERSION_CODE
import kotlinx.android.synthetic.main.activity_resource.*

class Resource : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        //1
        val ment = resources.getString(R.string.hello)
        Log.d("mentt", "ment: "+ment)

        //2
        val ment2 = getString(R.string.hello)
        Log.d("ment", "ment: "+ment2)

        // SDK 버전에 따른 분기 처리
        val color = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            button.setBackgroundColor(getColor(R.color.textview_color))
        } else {
            button.setBackgroundColor(resources.getColor(R.color.textview_color))
        }



        Log.d("mentt", "color: " + color)

    }
}