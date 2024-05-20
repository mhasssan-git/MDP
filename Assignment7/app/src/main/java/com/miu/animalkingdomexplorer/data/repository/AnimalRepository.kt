package com.miu.animalkingdomexplorer.data.repository


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import com.miu.animalkingdomexplorer.data.dao.AnimalDao
import com.miu.animalkingdomexplorer.data.database.AppDatabase
import com.miu.animalkingdomexplorer.data.model.Animal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class AnimalRepository {

    var animals = MutableLiveData<List<Animal>>()
    private lateinit var animalDao: AnimalDao

    constructor(context: Context) {
        animalDao = AppDatabase(context).getAnimalDao()
    }

    suspend fun getAnimals() {
        animals.value= animalDao.getAllAnimals()
    }

    suspend fun insertAnimal(animal: Animal) {
        animalDao.addAnimal(animal)
    }
}