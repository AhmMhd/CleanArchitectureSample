package com.cleansample

import android.app.Application
import android.content.Context
import com.cleansample.di.AppComponent
import com.cleansample.di.AppModule
import com.cleansample.di.DaggerAppComponent

class AppClass : Application() {

    override fun onCreate() {
        super.onCreate()
        context = this
    }
    companion object {
        lateinit var context : Context
        @JvmField
        var appComp: DaggerAppComponent? = null

        fun getAppComp() = appComp ?: createComponent()

        fun createComponent(): DaggerAppComponent {
            appComp = DaggerAppComponent.builder().appModule(AppModule(context)).build() as DaggerAppComponent
            return appComp as DaggerAppComponent
        }
    }

}