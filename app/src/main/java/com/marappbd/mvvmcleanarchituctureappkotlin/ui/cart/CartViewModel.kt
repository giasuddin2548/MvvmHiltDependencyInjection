package com.marappbd.mvvmcleanarchituctureappkotlin.ui.cart
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marappbd.mvvmcleanarchituctureappkotlin.data.local.CartRepository
import com.marappbd.mvvmcleanarchituctureappkotlin.model.CartModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(private val cartRepository: CartRepository)  : ViewModel(){

    private val _cartDataList = MutableLiveData<List<CartModel>>()
    var cartList: LiveData<List<CartModel>> =_cartDataList


    init {
        getCartData()
    }

    private fun getCartData(){
        try {
            viewModelScope.launch {
                val response = cartRepository.getCartItems()
                _cartDataList.postValue(response)
            }
        }catch (e:Exception){
            Log.d("", "$e")
        }
    }

}