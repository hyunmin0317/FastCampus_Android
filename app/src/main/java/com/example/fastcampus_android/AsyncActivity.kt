package com.example.fastcampus_android

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView

class AsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)
    }
}

class BackgroundAsyncTask(
    val progressbar : ProgressBar,
    val progressText : TextView
) : AsyncTask<>() {
    // params -> doInBackground 에서 사용할 타입
    // progess -> onProgree
}