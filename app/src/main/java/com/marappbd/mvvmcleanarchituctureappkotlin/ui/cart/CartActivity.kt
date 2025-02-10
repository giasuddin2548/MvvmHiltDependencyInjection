package com.marappbd.mvvmcleanarchituctureappkotlin.ui.cart

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.marappbd.mvvmcleanarchituctureappkotlin.databinding.ActivityCartBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding
    private val viewModel:CartViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        val productName = intent.getStringExtra("title")
        binding.toolbar.setTitle(productName)


    }
}