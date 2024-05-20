package com.miu.animalkingdomexplorer.ui.animaldetails

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.miu.animalkingdomexplorer.R
import com.miu.animalkingdomexplorer.data.model.Animal
import com.miu.animalkingdomexplorer.data.model.Data
import com.miu.animalkingdomexplorer.data.repository.AnimalRepository
import com.miu.animalkingdomexplorer.databinding.FragmentAnimalDetailsBinding
import com.miu.animalkingdomexplorer.ui.BaseFragment
import com.miu.animalkingdomexplorer.ui.OnAddListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.*

class AnimalDetailsFragment : BaseFragment() {
    private  lateinit var repository: AnimalRepository
    private lateinit var _binding: FragmentAnimalDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAnimalDetailsBinding.inflate(inflater, container, false)

        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.rvAnimalDetails.layoutManager = LinearLayoutManager(requireContext())
        repository=AnimalRepository(this.requireContext())

        repository.animals.observe(viewLifecycleOwner) {
            val animalAdapter = AnimalAdapter(it)
            _binding.rvAnimalDetails.adapter = animalAdapter
        }
        launch {
            repository.getAnimals()
        }
        _binding.buttonAdd.setOnClickListener{_->
            val dialog=AnimalAddDialogFragment()
            dialog.SetOnAddListner(object:OnAddListener<Data>{
                @SuppressLint("NotifyDataSetChanged")
                override suspend fun saveData(data: Data) {
                    val d=data as Animal
                    launch (Dispatchers.IO) {
                        repository.insertAnimal(d)
                    }
                    launch {
                        repository.getAnimals()
                    }
                }

            })
            dialog.show(childFragmentManager, "AnimalAddDialogFragment")
        }
    }

}