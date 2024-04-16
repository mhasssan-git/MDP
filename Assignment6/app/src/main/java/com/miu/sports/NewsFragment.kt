package com.miu.sports

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.miu.sports.databinding.FragmentNewsBinding
import com.miu.sports.databinding.FragmentSportsBinding

class NewsFragment : Fragment() {
    private lateinit var _binding: FragmentNewsBinding
    private lateinit var _data:ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _data = arrayListOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentNewsBinding.inflate(inflater,container,false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = getDataList()
        val adapter = NewsRecyleViewAdapter(data)
        _binding.rvNews.layoutManager = LinearLayoutManager(requireContext())
        _binding.rvNews.adapter = adapter
        _binding.btnAddNews.setOnClickListener { _ ->
            val dialog = NewsAddDialogFragment()
            dialog.SetOnAddListner(object : OnAddListener<Data> {
                @SuppressLint("NotifyDataSetChanged")
                override fun saveData(data: Data) {
                    val d = data as News
                    _data.add(d)
                    adapter.notifyDataSetChanged()
                }
            })
            dialog.show(childFragmentManager, "NewsAddDialogFragment")
        }
    }
    public fun getDataList(): List<News> {
        return _data
    }
}