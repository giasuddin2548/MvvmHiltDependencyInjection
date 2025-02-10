package com.marappbd.mvvmcleanarchituctureappkotlin.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.marappbd.mvvmcleanarchituctureappkotlin.databinding.ActivityHomeBinding
import com.marappbd.mvvmcleanarchituctureappkotlin.model.ProductModel
import com.marappbd.mvvmcleanarchituctureappkotlin.ui.cart.CartActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding:ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val list:ArrayList<ProductModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getProductData()
        setupData()

        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = HomeAdapter(list) { e ->
            onItemClick(e)
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setupData() {
        viewModel.productList.observe(this) {
            list.clear()
            list.addAll(it)
            binding.recyclerview.adapter?.notifyDataSetChanged()
        }
    }


    private fun onItemClick(e: ProductModel) {
        val intent = Intent(this, CartActivity::class.java)
        intent.putExtra("id", e.id)
        intent.putExtra("title", e.title)
        startActivity(intent)
    }
}