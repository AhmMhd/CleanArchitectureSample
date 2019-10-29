package com.domain.usecase

import com.domain.common.Result
import com.domain.model.User
import com.domain.repository.GetUserRepository
import com.google.gson.Gson
import javax.inject.Inject


class GetIUserUseCase @Inject constructor(
    private val getUserRepository: GetUserRepository,
    private val gson: Gson
) {

    suspend fun invoke(): Result<out Any> {

        val result = getUserRepository.getUsers()

        when (result) {
            is Result.Success -> {

                return Result.Success(
                    sortList(
                        result.data as List<User>
                    )
                )
            }
        }
        return result
    }

    fun sortList(list: List<User>) = list.sortedWith(compareBy { it.full_name })

}