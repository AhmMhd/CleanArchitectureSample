package com.cleansample

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.common.Result
import com.domain.model.User
import com.domain.usecase.GetIUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class ActivityViewModel(var userUseCase: GetIUserUseCase) : ViewModel() {


    private var users: MutableLiveData<List<User>> = MutableLiveData()
    val obUser: LiveData<List<User>>
        get() = users

    private var loader: MutableLiveData<Boolean> = MutableLiveData()
    val obLoader: LiveData<Boolean>
        get() = loader

    fun hitAPI() {
        viewModelScope.launch {
            loader.value = true
            val res = userUseCase.invoke()
            loader.value = false
            when (res) {
                is Result.Success -> {
                    users.value = res.data as List<User>
                    Log.d("Applog: ", "${res.data.toString()}")
                }
                else -> {
                }
            }
        }
    }
}