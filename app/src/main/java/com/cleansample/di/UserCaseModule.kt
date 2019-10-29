package com.cleansample.di

import com.data.repository.UserDataRepositoryImpl
import com.domain.repository.GetUserRepository
import dagger.Binds
import dagger.Module

@Module
abstract class UserCaseModule {

    @Binds
    abstract fun provideUserUserCase(userUseCaseImpl: UserDataRepositoryImpl): GetUserRepository
}
