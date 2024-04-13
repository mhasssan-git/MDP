package com.miu.sports

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miu.sports.databinding.SportsItemLayoutBinding

class SportsRecyleViewAdapter(private val data: List<Sport>) :
    RecyclerView.Adapter<SportsRecyleViewAdapter.MyViewHolder>() {
    class MyViewHolder(private val binding: SportsItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Sport) {
            binding.type.text = item.sportsType
            binding.name.text = item.sportName
            binding.instruction.text = item.instruction
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inlfater = LayoutInflater.from(parent.context)
        val binding = SportsItemLayoutBinding.inflate(inlfater, parent, false)
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