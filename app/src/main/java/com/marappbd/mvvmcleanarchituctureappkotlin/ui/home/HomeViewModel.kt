package com.marappbd.mvvmcleanarchituctureappkotlin.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marappbd.mvvmcleanarchituctureappkotlin.data.network.HomeRepository
import com.marappbd.mvvmcleanarchituctureappkotlin.model.ProductModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor( private val homeRepository: HomeRepository) : ViewModel(){

    private val _productData = MutableLiveData<List<ProductModel>> ()
    val productList: LiveData<List<ProductModel>> = _productData

//    init {
//        getProductData()
//    }

     fun getProductData() {
        try {

            viewModelScope.launch {
              val response =  homeRepository.getProductApi()
                _productData.postValue(response.body())
                //Log.d("NetworkError", "${response.body()}")
            }

        }catch (e:Exception){
            Log.d("NetworkError", "$e")
        }

    }



}