package com.example.foodcost.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.foodcost.db.dao.GoodDao
import com.example.foodcost.db.dao.PersonDao
import com.example.foodcost.db.dao.PurchaseDao
import com.example.foodcost.db.entity.Good
import com.example.foodcost.db.entity.Person
import com.example.foodcost.db.entity.Purchase

@Database(
    entities = [Good::class, Person::class, Purchase::class],
    version = 1, exportSchema = false
)
abstract class DataBase : RoomDatabase() {

    abstract fun goodDao(): GoodDao
    abstract fun personDao(): PersonDao
    abstract fun purchaseDao(): PurchaseDao

    companion object {
        @Volatile
        private var instance: DataBase? = null

        fun getDataBase(context: Context): DataBase? {
            if (instance == null) {
                synchronized(Database::class.java) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DataBase::class.java,
                        "DB"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }

            return instance
        }
    }
}