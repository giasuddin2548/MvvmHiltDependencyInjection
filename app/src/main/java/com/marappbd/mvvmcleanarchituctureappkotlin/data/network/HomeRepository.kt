package com.marappbd.mvvmcleanarchituctureappkotlin.data.network

import com.marappbd.mvvmcleanarchituctureappkotlin.model.ProductModel
import retrofit2.Response
import javax.inject.Inject


class HomeRepository @Inject constructor(private val api: ApiInterface){

    suspend fun getProductApi() : Response<List<ProductModel>>{
        return api.getProduct()
    }

}