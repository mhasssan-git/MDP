package com.miu.animalkingdomexplorer.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.miu.animalkingdomexplorer.data.model.Animal

@Dao
interface AnimalDao{
   @Query("SELECT * FROM animals")
   suspend fun getAllAnimals(): List<Animal>
    @Insert
    suspend fun addAnimal(animal:Animal)
}
