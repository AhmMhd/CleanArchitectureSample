package com.cleansample.di

import com.data.repository.UserDataRepository
import com.domain.repository.GetUserRepository
import com.domain.usecase.GetIUserUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class UserCaseModule {

    @Binds
    abstract fun provideUserUserCase(userUseCase: UserDataRepository): GetUserRepository
}