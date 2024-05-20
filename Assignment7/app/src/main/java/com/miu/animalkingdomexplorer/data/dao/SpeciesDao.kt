package com.miu.animalkingdomexplorer.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.miu.animalkingdomexplorer.data.model.Animal
import com.miu.animalkingdomexplorer.data.model.Species
@Dao
interface SpeciesDao{
    @Query("SELECT * FROM species")
    suspend fun getAllSpecies(): List<Species>
    @Query("SELECT * FROM species WHERE id = :speciesId")
    suspend fun getSpeciesById(speciesId: Long): Species

    @Insert
    suspend fun addSpecies(species: Species)
}
