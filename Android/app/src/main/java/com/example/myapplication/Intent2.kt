package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent2.*

class Intent2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent2)

        result.setOnClickListener {
            val number1 = intent.getIntExtra("number1", 0)
            val number2 = intent.getIntExtra("number2", 0)

            Log.d("number1", ""+number1)
            Log.d("number2", ""+number2)

            val result = number1 + number2
            val resultInt = Intent()
            resultInt.putExtra("result", result)

            setResult(RESULT_OK, resultInt)
            finish()    // Activity 종료
        }
   }
}