package com.marappbd.mvvmcleanarchituctureappkotlin.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.marappbd.mvvmcleanarchituctureappkotlin.model.CartModel


@Dao
interface CartDao {
    @Query("SELECT * FROM cart_table")
    suspend fun getAllCartItems(): List<CartModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCartItem(cartItem: CartModel)

    @Delete
    suspend fun deleteCartItem(cartItem: CartModel)
}
