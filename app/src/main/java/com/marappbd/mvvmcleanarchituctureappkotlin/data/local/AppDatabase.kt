package com.marappbd.mvvmcleanarchituctureappkotlin.data.local
import androidx.room.Database
import androidx.room.RoomDatabase
import com.marappbd.mvvmcleanarchituctureappkotlin.model.CartModel


@Database(entities = [CartModel::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cartDao(): CartDao
}