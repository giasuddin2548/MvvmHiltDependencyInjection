package com.marappbd.mvvmcleanarchituctureappkotlin.di
import android.content.Context
import androidx.room.Room
import com.marappbd.mvvmcleanarchituctureappkotlin.data.local.AppDatabase
import com.marappbd.mvvmcleanarchituctureappkotlin.data.local.CartDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "cart_database"
        ).build()
    }

    @Provides
    fun provideDao (db: AppDatabase): CartDao = db.cartDao()
}