package com.example.instagram

import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {

    @POST("user/signup/")
    fun register(
        @Body register: Register
    ): Call<User>
}