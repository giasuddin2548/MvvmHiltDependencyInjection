package com.marappbd.mvvmcleanarchituctureappkotlin.data.network

import com.marappbd.mvvmcleanarchituctureappkotlin.model.ProductModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/products")
    suspend fun getProduct() : Response<List<ProductModel>>
}