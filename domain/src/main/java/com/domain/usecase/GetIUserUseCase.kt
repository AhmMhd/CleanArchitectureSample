package com.domain.usecase

import com.domain.common.Result
import com.domain.repository.GetUserRepository
import javax.inject.Inject


class GetIUserUseCase @Inject constructor(
    private val getUserRepository: GetUserRepository
) {

    suspend fun invoke(): Result<String> {
        val result = getUserRepository.getUsers()
        if (result is Result.Success)
            println("APP: ${result.data.toString()}")
        return result
    }
//        runOnBackgroundThread {
//            val result = getItemsRepository.getItems()

//        }

}