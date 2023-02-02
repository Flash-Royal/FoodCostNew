package com.example.foodcost.db.dao

import androidx.room.*
import com.example.foodcost.db.entity.Good

@Dao
interface GoodDao {
    @Query("Select * from Good")
    suspend fun getGoods(): List<Good>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(good: Good)

    @Delete
    suspend fun delete(good: Good)
}