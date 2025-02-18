package com.marappbd.mvvmcleanarchituctureappkotlin.model

data class ProductModel(
    val category: String?,
    val description: String?,
    val id: Int?,
    val image: String?,
    val price: Double?,
    val rating: Rating?,
    val title: String?
)