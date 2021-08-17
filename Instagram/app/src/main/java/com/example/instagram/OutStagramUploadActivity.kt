package com.example.instagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_out_stagram_upload.*

class OutStagramUploadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_out_stagram_upload)


        all_list.setOnClickListener { startActivity(Intent(this, OutStagramPostListActivity::class.java)) }
        user_info.setOnClickListener { startActivity(Intent(this, OutStagramUserInfo::class.java)) }
        my_list.setOnClickListener { startActivity(Intent(this, OutStagramMyPostListActivity::class.java)) }
    }
}