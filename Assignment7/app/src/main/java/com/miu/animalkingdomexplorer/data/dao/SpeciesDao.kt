package com.miu.animalkingdomexplorer.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.miu.animalkingdomexplorer.data.model.Species

interface SpeciesDao{
    @Query("SELECT * FROM species")
    fun getAllSpecies(): LiveData<List<Species>>
    @Query("SELECT * FROM species WHERE id = :speciesId")
    fun getSpeciesById(speciesId: Long): LiveData<Species>
}
