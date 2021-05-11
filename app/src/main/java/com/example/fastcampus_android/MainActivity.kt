package com.example.fastcampus_android

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scrollview)

        Log.d("life_cylce", "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d("life_cylce", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("life_cylce", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("life_cylce", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life_cylce", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("life_cylce", "onDestroy")
    }
}