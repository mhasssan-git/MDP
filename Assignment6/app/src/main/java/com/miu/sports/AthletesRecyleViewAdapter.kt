package com.miu.sports

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miu.sports.databinding.AtheleteItemLayoutBinding
import com.miu.sports.databinding.SportsItemLayoutBinding

class AthletesRecyleViewAdapter(private val data: List<Athlete>) :
    RecyclerView.Adapter<AthletesRecyleViewAdapter.MyViewHolder>() {
    class MyViewHolder(private val binding: AtheleteItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Athlete) {
            binding.tvName.text = "Name: ${item.name}"
            binding.tvSport.text = "Sport: "+item.sport
            binding.tvCountry.text = "Country: "+item.country
            binding.tvPersonalBest.text = "Personal Best: "+item.personalBest
            binding.tvAward.text = "Medals Awarded: "+item.award
            binding.tvFact.text = "Facts: "+item.fact


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inlfater = LayoutInflater.from(parent.context)
        val binding = AtheleteItemLayoutBinding.inflate(inlfater, parent, false)
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