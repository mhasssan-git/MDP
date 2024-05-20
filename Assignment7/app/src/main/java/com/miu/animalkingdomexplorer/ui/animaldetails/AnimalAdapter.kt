package com.miu.animalkingdomexplorer.ui.animaldetails

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miu.animalkingdomexplorer.data.model.Animal
import com.miu.animalkingdomexplorer.databinding.AnimalItemLayoutBinding


class AnimalAdapter(private val data: List<Animal>) :
    RecyclerView.Adapter<AnimalAdapter.MyViewHolder>() {
    class MyViewHolder(private val binding: AnimalItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(item: Animal) {
            binding.tvName.text = "Name: ${item.name}"
            binding.tvDiet.text="Diet: ${item.diet}"
            binding.tvHabitate.text="Habitate: ${item.habitat}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inlfater = LayoutInflater.from(parent.context)
        val binding = AnimalItemLayoutBinding.inflate(inlfater, parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }
}