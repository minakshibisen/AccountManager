package com.example.accountmanager.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ConnectDao {

    @Insert
    suspend fun insertConnect(Connect: Connect)

    @Update
    suspend fun updateConnect(Connect: Connect)

    @Delete
    suspend fun deleteConnect(Connect: Connect)

    @Query("SELECT * FROM Connect")
    fun getContacts(): LiveData<List<Connect>>

//room check krta hai ki iska return typ live data to n hai agr live data hota hai to use by default
    //background thread pr data perform hoga live data ka use krke
}


