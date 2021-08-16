package com.example.myapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_shared_preference.*

// MODE
// - MODE_PRIVATE : 생성한 application 에서만 사용 가능
// - MODE_WORLD_READABLE : 다른 application 사용 가능 -> 읽기만 가능
// - MODE_WORLD_WRITEABLE : 다른 application 사용 가능 -> 기록도 가능
// - MODE_MULTI_PROCESS : 이미 호출되어 사용 중인지 체크
// - MODE_APPEND : 기존 preference에 신규로 추가

// SharedPreference
// sp1 -> Sharedpreference
//        (Key,Value) -> ("Hello", "안녕하세요")
// sp2 -> Sharedpreference
//        (Key,Value) -> ("Hello", "안녕하세요2")

class SharedPreferenceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preference)

        // SharedPreference 에 저장하는 방법
        save_btn.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPreference.edit()
            editor.putString("hello", "안녕하세요")
            editor.putString("goodbye", "안녕히가세요")
            editor.commit()
        }

        // SharedPreference 에 값을 불러오는 방법
        load_button.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val value1 = sharedPreference.getString("hello", "no data1")
            val value2 = sharedPreference.getString("goodbye", "no data2")
            Log.d("key-value", "Value 1 : "+value1)
            Log.d("key-value", "Value 2 : "+value2)
        }

        delete_button.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.remove("hello")
            editor.commit()
        }

        delete_all_button.setOnClickListener {
            val sharedPreference = getSharedPreferences("sp1", MODE_PRIVATE)
            val editor = sharedPreference.edit()
            editor.clear()
            editor.commit()
        }
    }
}