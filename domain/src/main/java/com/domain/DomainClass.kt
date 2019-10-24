package com.domain

import android.util.Log
import javax.inject.Inject

class DomainClass @Inject constructor(){
    init {
        Log.d("AppLog: ","hello from domain")
    }
}