package com.miu.animalkingdomexplorer.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
interface Data {}
@Entity(tableName = "Animals")
data class Animal(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val name: String,
    val habitat: String,
    val diet: String
):Data