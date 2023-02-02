package com.example.foodcost.db.dao

import androidx.room.*
import com.example.foodcost.db.entity.Purchase

@Dao
interface PurchaseDao {
    @Query("Select * from Purchase")
    suspend fun getPurchases(): List<Purchase>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(purchase: Purchase)

    @Delete
    suspend fun delete(purchase: Purchase)
}