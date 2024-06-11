package com.example.accountmanager.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Connect::class], version = 1)
abstract class ConnectDatabase : RoomDatabase() {

   abstract fun ConnectDao():ConnectDao
}