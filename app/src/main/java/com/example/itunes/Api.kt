package com.example.itunes


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface Api {
    var searchTerm: String

    @GET("search")
    fun getSongs(@Query("term") searchTerm: String): Call<Results?>


    companion object {
        const val BASE_URL = "https://itunes.apple.com/"
    }
}

