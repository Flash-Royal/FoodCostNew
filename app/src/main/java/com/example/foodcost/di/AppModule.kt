package com.example.foodcost.di

import android.content.Context
import com.example.foodcost.db.DataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.annotation.Nullable
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Nullable
    @Singleton
    @Provides
    fun provideDB(@ApplicationContext context: Context) = DataBase.getDataBase(context)

    @Singleton
    @Provides
    fun provideGoodDao(@Nullable db: DataBase) = db.goodDao()

    @Singleton
    @Provides
    fun providePersonDao(@Nullable db: DataBase) = db.personDao()

    @Singleton
    @Provides
    fun providePurchaseDao(@Nullable db: DataBase) = db.purchaseDao()
}