package com.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.data.db.dao.UserDao
import com.domain.model.User
import javax.inject.Singleton

@Singleton
@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class MyDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}