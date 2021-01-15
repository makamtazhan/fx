package com.example.fx

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    private const val BASE_URL = "https://api.covid19api.com/"
    fun getApiService(): ApiService{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }
}