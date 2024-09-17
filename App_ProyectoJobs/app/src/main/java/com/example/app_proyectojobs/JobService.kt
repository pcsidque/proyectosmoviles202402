package com.example.app_proyectojobs

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface JobService {
    @GET("positions.json")
    fun searchJob(@Query("description") description: String): Call<List<Job>>
}