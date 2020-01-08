package com.example.meenaclickmvp.network

import com.example.meenaclickmvp.model.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceApi {

    @GET("catalog-contents/1/cereals?page=1")
    fun getProduct(): Call<ApiResponse>
}