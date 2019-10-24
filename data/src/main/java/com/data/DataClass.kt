package com.data

import android.util.Log
import javax.inject.Inject

class DataClass @Inject constructor(){
    init {
        Log.d("AppLog: ","hello from data")
    }
}