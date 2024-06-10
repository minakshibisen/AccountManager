package com.example.accountmanager.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Connect")
data class Connect(
    @PrimaryKey(autoGenerate = true)
    val sno :Long,
    val date :String,
    val particular :String,
    val credit :String,
    val debit :String

)
