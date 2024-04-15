package com.miu.sports

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miu.sports.databinding.NewsItemLayoutBinding
import com.miu.sports.databinding.SportsItemLayoutBinding

class NewsRecyleViewAdapter(private val data: List<News>) :
    RecyclerView.Adapter<NewsRecyleViewAdapter.MyViewHolder>() {
    class MyViewHolder(private val binding: NewsItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: News) {

            binding.tvNewsTitle.text = item.title
            binding.tvNewsDetails.text = item.description
            Glide.with(binding.root.context)
                .load(item.imageUrl)
                .into(binding.ivNews)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inlfater = LayoutInflater.from(parent.context)
        val binding = NewsItemLayoutBinding.inflate(inlfater, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }
}