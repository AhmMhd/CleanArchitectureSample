package com.cleansample.di

import com.cleansample.MainActivity
import com.gymrabbit.di.app.module.NetworkModule
import com.gymrabbit.di.app.module.RetrofitModule
import dagger.Component

@Component(
    modules = [
        RetrofitModule::class,
        NetworkModule::class,
        UserCaseModule::class]
)
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}