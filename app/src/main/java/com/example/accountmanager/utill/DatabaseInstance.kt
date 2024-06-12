package com.example.accountmanager.utill

import android.content.Context
import androidx.room.Room
import com.example.accountmanager.room.AppDatabase

object DatabaseProvider {
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "transaction_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}