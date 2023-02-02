package com.example.foodcost.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Purchase(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val personID: Int,
    val goodID: Int,
    var percent: Float,
)
