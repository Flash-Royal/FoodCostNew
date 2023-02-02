package com.example.foodcost.repository

import com.example.foodcost.db.dao.*
import com.example.foodcost.db.entity.*
import javax.inject.Inject

class Repository @Inject constructor(
    private val goodDao: GoodDao,
    private val personDao: PersonDao,
    private val purchaseDao: PurchaseDao,
){
    suspend fun getGoods() = goodDao.getGoods()
    suspend fun getPersons() = personDao.getPersons()
    suspend fun getPurchases() = purchaseDao.getPurchases()

    suspend fun insertGood(good: Good) = goodDao.insert(good)
    suspend fun insertPerson(person: Person) = personDao.insert(person)
    suspend fun insertPurchase(purchase: Purchase) = purchaseDao.insert(purchase)

    suspend fun deleteGood(good: Good) = goodDao.delete(good)
    suspend fun deletePerson(person: Person) = personDao.delete(person)
    suspend fun deletePurchase(purchase: Purchase) = purchaseDao.delete(purchase)
}