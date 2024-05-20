package com.miu.animalkingdomexplorer.ui.speciesdetails

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.miu.animalkingdomexplorer.R
import com.miu.animalkingdomexplorer.data.model.Animal
import com.miu.animalkingdomexplorer.data.model.Data
import com.miu.animalkingdomexplorer.data.model.Species
import com.miu.animalkingdomexplorer.data.repository.AnimalRepository
import com.miu.animalkingdomexplorer.data.repository.SpeciesRepository
import com.miu.animalkingdomexplorer.databinding.FragmentAnimalDetailsBinding
import com.miu.animalkingdomexplorer.databinding.FragmentSpeciesDetailsBinding
import com.miu.animalkingdomexplorer.ui.BaseFragment
import com.miu.animalkingdomexplorer.ui.OnAddListener
import com.miu.animalkingdomexplorer.ui.animaldetails.AnimalAdapter
import com.miu.animalkingdomexplorer.ui.animaldetails.AnimalAddDialogFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class SpeciesDetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentSpeciesDetailsBinding
    private lateinit var repository: SpeciesRepository
    private lateinit var _binding: FragmentSpeciesDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSpeciesDetailsBinding.inflate(inflater, container, false)

        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.rvSpeciesDetails.layoutManager = LinearLayoutManager(requireContext())
        repository = SpeciesRepository(this.requireContext())


        repository.specieses.observe(viewLifecycleOwner) {
            val speciesAdapter = SpeciesAdapter(it)
            _binding.rvSpeciesDetails.adapter = speciesAdapter
        }

        launch {
            repository.getSpecies()
        }
        _binding.buttonAdd.setOnClickListener { _ ->
            val dialog = SpeciesAddDialogFragment()
            dialog.SetOnAddListner(object : OnAddListener<Data> {
                @SuppressLint("NotifyDataSetChanged")
                override suspend fun saveData(data: Data) {
                    val d = data as Species
                    launch (Dispatchers.IO) {
                        repository.insertSpecies(d)
                    }
                    launch {
                        repository.getSpecies()
                    }

                }

            })
            dialog.show(childFragmentManager, "SpeciesAddDialogFragment")
        }
    }
}