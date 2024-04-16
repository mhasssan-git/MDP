package com.miu.sports

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.miu.sports.databinding.EventItemLayoutBinding
import com.miu.sports.databinding.SportsItemLayoutBinding

class EventRecyleViewAdapter(private val data: List<Event>) :
    RecyclerView.Adapter<EventRecyleViewAdapter.MyViewHolder>() {
    class MyViewHolder(private val binding: EventItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Event) {
            binding.tvEventName.text = item.name
            binding.tvDate.text = item.date
            binding.tvEventDescription.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inlfater = LayoutInflater.from(parent.context)
        val binding = EventItemLayoutBinding.inflate(inlfater, parent, false)
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