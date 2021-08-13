package com.example.fastcampus_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.fastcampus_android.ui.main.LibraryFragment
import kotlinx.android.synthetic.main.library_activity.*

class LibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.library_activity)

        Glide.with(this@LibraryActivity)
            .load("https://www.smu.ac.kr/_res/ko/img/sub1/img-sub1-signiture1-blue.png")
            .centerCrop()
            .into(glide)

        Glide.with(this@LibraryActivity)
            .load("https://www.smu.ac.kr/_res/ko/img/sub1/img-sub1-signiture1-blue.png")
            .into(glide2)
    }
}