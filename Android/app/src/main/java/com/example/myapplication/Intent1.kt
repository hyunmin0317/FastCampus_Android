package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent.*
import kotlinx.android.synthetic.main.activity_intent2.*

class Intent1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)

        change_activty.setOnClickListener {
            // 명시적 인텐트 -> 정확히 대상에게 요청
            val intent = Intent(this@Intent1, Intent2::class.java)

            // Key, Value 방식 -> Key와 value를 쌍으로 만들어 저장한다. -> Dictionary
            intent.putExtra("number1", 1)
            intent.putExtra("number2", 2)
            startActivity(intent)

            val intent2 = Intent(this@Intent1, Intent2::class.java)
            // Apply ->
            intent2.apply {
                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivityForResult(intent2, 200)


        }

        intent_naver.setOnClickListener {
            // 암시적 인텐트 -> 할 수 있는 대상에게 요청
            val intent3 = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"))
            startActivity(intent3)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 200) {
            Log.d("number", ""+requestCode)
            Log.d("number", ""+resultCode)
            val result = data?.getIntExtra("result", 0)
            Log.d("number",""+result)
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
}