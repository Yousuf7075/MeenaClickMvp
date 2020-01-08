package com.example.meenaclickmvp.network

import com.example.apiretrofitdemo.Utils.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    val instance: ServiceApi by lazy {
        val retrofit = Retrofit
            .Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return@lazy retrofit.create(ServiceApi ::class.java)
    }
}