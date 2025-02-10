package com.marappbd.mvvmcleanarchituctureappkotlin.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.marappbd.mvvmcleanarchituctureappkotlin.R
import com.marappbd.mvvmcleanarchituctureappkotlin.databinding.ActivityHomeBinding
import com.marappbd.mvvmcleanarchituctureappkotlin.model.ProductModel
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

    @SuppressLint("NotifyDataSetChanged")
    private fun onItemClick(e: ProductModel) {
        list.add(e)
        binding.recyclerview.adapter?.notifyDataSetChanged()
        Toast.makeText(this, "Lenght: ${list.size}", Toast.LENGTH_SHORT).show()

    }
}