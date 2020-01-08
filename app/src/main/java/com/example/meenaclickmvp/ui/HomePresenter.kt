package com.example.meenaclickmvp.ui

import android.content.Context
import android.util.Log
import com.example.meenaclickmvp.model.ApiResponse
import com.example.meenaclickmvp.model.CatalogProductsItem
import com.example.meenaclickmvp.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(val view: HomeContract.View): HomeContract.Presenter {
    lateinit var productList : ArrayList<CatalogProductsItem>

    //call data
    override fun receivedApiData() {
        ApiClient.
            instance.getProduct().enqueue(object : Callback<ApiResponse>{
            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                Log.d("failed", t.message)
            }

            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if(response.isSuccessful){
                    productList = response.body() !!.catalogProducts as ArrayList<CatalogProductsItem>
                    view.setDataIntoAdapter(productList)

                    for (i in productList){
                        Log.d("data",i.productName)
                    }
                }
            }

        })
    }
}