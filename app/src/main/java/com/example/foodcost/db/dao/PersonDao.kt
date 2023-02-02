package com.example.foodcost.db.dao

import androidx.room.*
import com.example.foodcost.db.entity.Person

@Dao
interface PersonDao {
    @Query("Select * from Person")
    suspend fun getPersons(): List<Person>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(person: Person)

    @Delete
    suspend fun delete(person: Person)
}