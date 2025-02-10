package com.marappbd.mvvmcleanarchituctureappkotlin.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.text.toLowerCase
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.marappbd.mvvmcleanarchituctureappkotlin.databinding.ActivityHomeBinding
import com.marappbd.mvvmcleanarchituctureappkotlin.model.ProductModel
import com.marappbd.mvvmcleanarchituctureappkotlin.ui.cart.CartActivity
import dagger.hilt.android.AndroidEntryPoint
import java.util.Locale

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val list = ArrayList<ProductModel>()
    private val filteredList = ArrayList<ProductModel>()
    private lateinit var adapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getProductData()
        setupData()

        // Set up RecyclerView and Adapter
        adapter = HomeAdapter(filteredList) { e -> onItemClick(e) }
        binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = adapter

        // Search text listener
        binding.searchText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterList(s.toString().trim())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setupData() {
        viewModel.productList.observe(this) { products ->
            list.clear()
            list.addAll(products)

            // Initially, filteredList is the same as list
            filteredList.clear()
            filteredList.addAll(products)
            adapter.notifyDataSetChanged()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun filterList(query: String) {
        filteredList.clear()

        if (query.isEmpty()) {
            filteredList.addAll(list)
        } else {
            filteredList.addAll(list.filter { it.title!!.contains(query, ignoreCase = true) })
        }

        adapter.notifyDataSetChanged()
    }

    private fun onItemClick(e: ProductModel) {
        val intent = Intent(this, CartActivity::class.java).apply {
            putExtra("id", e.id)
            putExtra("title", e.title)
        }
        startActivity(intent)
    }
}
