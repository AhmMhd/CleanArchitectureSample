package com.data.repository.local

import androidx.room.Room
import androidx.room.RoomDatabase
import com.data.db.MyDatabase
import com.data.network.API_URL_GET_USER_LIST
import com.data.network.NetworkCall
import com.domain.common.Result
import com.domain.model.User
import com.domain.repository.GetUserRepository
import javax.inject.Inject


class UserLocalDataSource @Inject constructor(
    private val db: MyDatabase
) : GetUserRepository {
    override suspend fun getUsers(): Result<out Any> {
        return Result.Local(db.userDao().getAll())
    }

    suspend fun storeUsers(users: List<User>) =
        users.forEach {
            db.userDao().insert(it)
        }


//    suspend fun getUsers() = networkCall.get(API_URL_GET_USER_LIST)
}