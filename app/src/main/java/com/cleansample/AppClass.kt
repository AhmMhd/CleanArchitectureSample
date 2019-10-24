package com.cleansample

import android.app.Application
import com.cleansample.di.AppComponent
import com.cleansample.di.DaggerAppComponent

class AppClass : Application() {
    companion object {

        @JvmField
        var appComp: DaggerAppComponent? = null

        fun getAppComp() = appComp ?: createComponent()

        fun createComponent(): DaggerAppComponent {
            appComp = DaggerAppComponent.builder().build() as DaggerAppComponent
            return appComp as DaggerAppComponent
        }
    }

}