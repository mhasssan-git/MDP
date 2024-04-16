package com.miu.sports

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.miu.sports.databinding.FragmentAthlatesBinding

class AthletesFragment : Fragment() {
    private lateinit var _binding: FragmentAthlatesBinding
    private lateinit var _data: ArrayList<Athlete>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _data = arrayListOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAthlatesBinding.inflate(inflater, container, false)
        return _binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data= getDataList()
        val adapter = AthletesRecyleViewAdapter(data)
        _binding.rvAtheletes.layoutManager = LinearLayoutManager(requireContext())
        _binding.rvAtheletes.adapter = adapter
        _binding.btnAddAthletes.setOnClickListener { _ ->
            val dialog = AtheleteAddDialogFragment()
            dialog.SetOnAddListner(object : OnAddListener<Data> {
                @SuppressLint("NotifyDataSetChanged")
                override fun saveData(data: Data) {
                    val d = data as Athlete
                    _data.add(d)
                    adapter.notifyDataSetChanged()
                    Log.d("AthletesFragment",_data.size.toString())
                }
            })
            dialog.show(childFragmentManager, "SportAddDialogFragment")
        }
    }
    public fun getDataList(): ArrayList<Athlete> {
        return _data
    }
}