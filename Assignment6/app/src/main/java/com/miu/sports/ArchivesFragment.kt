package com.miu.sports

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.miu.sports.databinding.FragmentEventBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ArchivesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ArchivesFragment : Fragment() {
    private lateinit var _binding: FragmentEventBinding
    private lateinit var _data: ArrayList<Event>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _data = arrayListOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEventBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data= getDataList()
        val adapter = ArchiveEventRecyleViewAdapter(data)
        _binding.rvEvent.layoutManager = LinearLayoutManager(requireContext())
        _binding.rvEvent.adapter = adapter
        _binding.btnAddEvent.setOnClickListener { _ ->
            val dialog = ArchiveEventAddDialogFragment()
            dialog.SetOnAddListner(object : OnAddListener<Data> {
                @SuppressLint("NotifyDataSetChanged")
                override fun saveData(data: Data) {
                    val d = data as Event
                    _data.add(d)
                    adapter.notifyDataSetChanged()
                    Log.d("AthletesFragment",_data.size.toString())
                }
            })
            dialog.show(childFragmentManager, "SportAddDialogFragment")
        }
    }

    public fun getDataList(): ArrayList<Event> {
        return _data
    }
}