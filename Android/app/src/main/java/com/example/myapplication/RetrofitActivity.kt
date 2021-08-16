package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)

        // http://mellowcode.org/json/students/
        // http://mellowcode.org/test/code/
        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(RetrofitService::class.java)

        // GET 요청
        service.getStudentsList().enqueue(object : Callback<ArrayList<PersonFromServer>>{
            override fun onResponse(
                call: Call<ArrayList<PersonFromServer>>,
                response: Response<ArrayList<PersonFromServer>>
            ) {
                if (response.isSuccessful) {
                    val personList = response.body()
                    Log.d("retrofitt", "res : "+personList?.get(0)?.age)

//                    val code = response.code()
//                    val error = response.errorBody()
//                    val header = response.headers()
                }
            }

            override fun onFailure(call: Call<ArrayList<PersonFromServer>>, t: Throwable) {
                Log.d("retrofitt", "Error")

//                call.isCanceled
//                call.isExecuted
//                call.cancel()
            }
        })

        // POST 요청 (1)
//        val params = HashMap<String, Any>()
//        params.put("name", "김개똥")
//        params.put("age", 20)
//        params.put("intro", "안녕하세요")
//        service.createStudent(params).enqueue(object : Callback<PersonFromServer>{
//            override fun onResponse(
//                call: Call<PersonFromServer>,
//                response: Response<PersonFromServer>
//            ) {
//                if (response.isSuccessful) {
//                    val person = response.body()
//                    Log.d("retrofitt", "name : "+person?.name)
//                }
//            }
//
//            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
//                Log.d("retrofitt", "Error")
//            }
//        })

        // POST 요청 (2)
        val person = PersonFromServer(name = "김철수", age = 12, intro = "hello")
        service.createStudentEasy(person).enqueue(object : Callback<PersonFromServer> {
            override fun onResponse(
                call: Call<PersonFromServer>,
                response: Response<PersonFromServer>
            ) {
                if (response.isSuccessful) {
                    val person = response.body()
                    Log.d("retrofitt", "name : "+person?.name)
                }
            }

            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {
                Log.d("retrofitt", "Error")
            }
        })
    }
}