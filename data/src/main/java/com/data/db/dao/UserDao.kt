package com.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.domain.model.User

@Dao
interface UserDao {
    @Query("SELECT * from User")
    suspend fun getAll(): List<User>

    @Query("SELECT * from User LIMIT 1")
    suspend fun getUser(): User

    @Insert(onConflict = REPLACE)
    suspend fun insert(user: User)

    @Query("DELETE from User")
    suspend fun deleteAll(): Int

    @Update
    suspend fun updateUser(user: User)
}
