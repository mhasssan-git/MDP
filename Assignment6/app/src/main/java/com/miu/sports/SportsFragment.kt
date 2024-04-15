package com.miu.sports

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.miu.sports.SportAddDialogFragment.OnAddSportsListener
import com.miu.sports.databinding.FragmentSportsBinding


class SportsFragment : Fragment() {
    private lateinit var _binding: FragmentSportsBinding
    private lateinit var _data:ArrayList<Sport>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _data= arrayListOf()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentSportsBinding.inflate(inflater,container,false)
        return _binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data=getDataList()
        val adapter=SportsRecyleViewAdapter(data)
        _binding.rvSports.layoutManager=GridLayoutManager(requireContext(),2)
        _binding.rvSports.adapter=adapter
        _binding.btnAddSports.setOnClickListener{ _->
            val dialog=SportAddDialogFragment()
            dialog.SetOnAddSportsListener(object:OnAddSportsListener{
                override fun saveSportsData(sport: Sport) {
                    _data.add(sport)

                }

            })
            dialog.show(childFragmentManager,"SportAddDialogFragment")
        }
    }
    private fun getDataList(): List<Sport> {
        return _data

    }
}