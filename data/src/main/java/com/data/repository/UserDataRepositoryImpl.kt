package com.data.repository


import android.util.Log
import android.widget.Toast
import com.data.mapper.UserMapper
import com.data.repository.local.UserLocalDataSource
import com.data.repository.remote.UserRemoteDataSource
import com.data.response.UserResponse
import com.domain.common.Result
import com.domain.repository.GetUserRepository
import com.google.gson.Gson
import javax.inject.Inject

class UserDataRepositoryImpl @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource,
    private val userLocalDataSource: UserLocalDataSource,
    private val mapper : UserMapper,
    private val gson: Gson
) :
    GetUserRepository {

    override suspend fun getUsers() : Result<out Any>
    {
        val res = userRemoteDataSource.getUsers()
        when (res) {
            is Result.Success-> {
                val userResponse = gson.fromJson(res.data.toString(),Array<UserResponse>::class.java).asList()
                Log.d("Applog: ","$userResponse")
                userLocalDataSource.storeUsers(mapper.transform(userResponse))
                return Result.Success(mapper.transform(userResponse))
            }
            is Result.Local-> {
                return Result.Success(res.data)
            }
            else -> {
                return res
            }
        }

    }
}