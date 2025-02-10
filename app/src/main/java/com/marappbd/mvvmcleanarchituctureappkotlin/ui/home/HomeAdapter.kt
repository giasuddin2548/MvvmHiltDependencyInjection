package com.marappbd.mvvmcleanarchituctureappkotlin.ui.home
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marappbd.mvvmcleanarchituctureappkotlin.R
import com.marappbd.mvvmcleanarchituctureappkotlin.databinding.HomeItemLayoutBinding
import com.marappbd.mvvmcleanarchituctureappkotlin.model.ProductModel


class HomeAdapter(private val dataList: List<ProductModel>, val onclick: (ProductModel) -> Unit) : RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding: HomeItemLayoutBinding = HomeItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  HomeViewHolder(binding)
    }
    override fun getItemCount(): Int {
        return dataList.size
    }
    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = dataList[dataList.size - 1 - position]


        Glide
            .with(holder.itemView)
            .load(item.image)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.binding.itemImage)

        holder.binding.textTitle.text = item.title
        holder.binding.textPrice.text = "${item.price}"
        holder.binding.textDes.text = item.description

        holder.itemView.setOnClickListener {
            onclick(item)
        }

    }
}

class HomeViewHolder (var binding: HomeItemLayoutBinding) : RecyclerView.ViewHolder (binding.root)