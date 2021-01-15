package com.example.fx

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("countries")
    fun getCountries(): Call<List<Country>>

    @GET("country/{slug}")
    fun getStatistics(@Path("slug")slug: String): Call<List<ApiResponse>>

}