package com.data.repository.remote

import com.data.network.API_URL_GET_USER_LIST
import com.data.network.NetworkCall
import javax.inject.Inject


class UserRemoteDataSource @Inject constructor(
    private val networkCall: NetworkCall
) {

    suspend fun getUsers() = networkCall.get(API_URL_GET_USER_LIST)
}