package com.cleansample.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides

@Module
object UtilModule {

    @JvmStatic
    @Provides
    fun provideGson() = Gson()
}