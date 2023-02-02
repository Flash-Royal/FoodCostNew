package com.example.foodcost.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Person(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var name: String,
)