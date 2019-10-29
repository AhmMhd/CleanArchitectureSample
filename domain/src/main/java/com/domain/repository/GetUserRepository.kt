package com.domain.repository

import com.domain.common.Result


interface GetUserRepository {
    suspend fun getUsers(): Result<out Any>
}