package com.marappbd.mvvmcleanarchituctureappkotlin.data.local

import com.marappbd.mvvmcleanarchituctureappkotlin.model.CartModel
import javax.inject.Inject


class CartRepository @Inject constructor(private val cartDao: CartDao) {
    suspend fun getCartItems(): List<CartModel> = cartDao.getAllCartItems()
    suspend fun addCartItem(cartItem: CartModel) = cartDao.insertCartItem(cartItem)
    suspend fun removeCartItem(cartItem: CartModel) = cartDao.deleteCartItem(cartItem)
}