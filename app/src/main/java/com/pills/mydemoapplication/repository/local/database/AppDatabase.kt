package com.pills.mydemoapplication.repository.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pills.mydemoapplication.repository.local.dao.UserDao
import com.pills.mydemoapplication.repository.local.entities.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}