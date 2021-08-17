package com.example.instagram

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_out_stagram_my_post_list.*

class OutStagramMyPostListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_out_stagram_my_post_list)

        all_list.setOnClickListener { startActivity(Intent(this, OutStagramPostListActivity::class.java)) }
        user_info.setOnClickListener { startActivity(Intent(this, OutStagramUserInfo::class.java)) }
        upload.setOnClickListener { startActivity(Intent(this, OutStagramUploadActivity::class.java)) }
    }
}