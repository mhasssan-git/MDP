package com.miu.animalkingdomexplorer.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.miu.animalkingdomexplorer.data.dao.AnimalDao
import com.miu.animalkingdomexplorer.data.dao.SpeciesDao
import com.miu.animalkingdomexplorer.data.database.AppDatabase
import com.miu.animalkingdomexplorer.data.model.Animal
import com.miu.animalkingdomexplorer.data.model.Species

class SpeciesRepository {
    var specieses = MutableLiveData<List<Species>>()
    private lateinit var speciesDao: SpeciesDao

    constructor(context: Context) {
        speciesDao = AppDatabase(context).getSpeciesDao()
    }

    suspend fun getSpecies() {
        specieses.value= speciesDao.getAllSpecies()
    }

    suspend fun insertSpecies(species: Species) {
        speciesDao.addSpecies(species)
    }
}