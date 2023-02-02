package com.example.foodcost.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Good(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var name: String,
    var price: Int,
)
