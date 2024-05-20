package com.miu.animalkingdomexplorer.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.miu.animalkingdomexplorer.R
import com.miu.animalkingdomexplorer.databinding.FragmentDashboardBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {

    private lateinit var _binding: FragmentDashboardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentDashboardBinding.inflate(inflater,container,false)

       _binding.apply {
           btnAnimal.setOnClickListener{
               val directions=DashboardFragmentDirections.actionDashboardFragmentToAnimalDetailsFragment()
           findNavController().navigate(directions)
           }
           bntSpecies.setOnClickListener{
               val directions=DashboardFragmentDirections.actionDashboardFragmentToSpeciesDetailsFragment()
               findNavController().navigate(directions)
           }
       }

        return _binding.root
    }


}