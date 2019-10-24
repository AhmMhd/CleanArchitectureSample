package com.data.repository


import com.data.repository.remote.UserRemoteDataSource
import com.domain.common.Result
import com.domain.repository.GetUserRepository
import javax.inject.Inject

class UserDataRepository @Inject constructor(
    private val userRemoteDataSource: UserRemoteDataSource
) :
    GetUserRepository {
    override suspend fun getUsers(): Result<String> {
        val result = userRemoteDataSource.getUsers()
        if (result is Result.Success<*>)
            return Result.Success(result.data.toString())

        return Result.Error("something went wrong")
    }

}