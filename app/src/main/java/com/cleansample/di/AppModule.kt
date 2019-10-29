package com.cleansample.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(var context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    fun provideResource() = context.resources

}