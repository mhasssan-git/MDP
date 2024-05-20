package com.miu.animalkingdomexplorer.ui.speciesdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miu.animalkingdomexplorer.data.model.Animal
import com.miu.animalkingdomexplorer.data.model.Species
import com.miu.animalkingdomexplorer.databinding.SpeciesItemLayoutBinding


class SpeciesAdapter(private val data:List<Species>):
    RecyclerView.Adapter<SpeciesAdapter.MyViewHolder>() {

    class MyViewHolder(private val binding: SpeciesItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Species) {
            binding.tvName.text = "Name: ${item.name}"
            binding.tvDescription.text="Description: ${item.description}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inlfater = LayoutInflater.from(parent.context)
        val binding = SpeciesItemLayoutBinding.inflate(inlfater, parent, false)
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