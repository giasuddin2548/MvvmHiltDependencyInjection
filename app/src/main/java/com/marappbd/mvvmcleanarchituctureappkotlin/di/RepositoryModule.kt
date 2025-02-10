package com.marappbd.mvvmcleanarchituctureappkotlin.di

import com.marappbd.mvvmcleanarchituctureappkotlin.data.local.CartDao
import com.marappbd.mvvmcleanarchituctureappkotlin.data.local.CartRepository
import com.marappbd.mvvmcleanarchituctureappkotlin.data.network.ApiInterface
import com.marappbd.mvvmcleanarchituctureappkotlin.data.network.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    fun provideHomeRepository(api: ApiInterface): HomeRepository {
        return HomeRepository(api)
    }

    @Provides
    fun provideCartRepository(cartDao: CartDao): CartRepository {
        return CartRepository(cartDao)
    }
}