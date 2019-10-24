package com.cleansample

import androidx.lifecycle.ViewModel
import com.domain.usecase.GetIUserUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ActivityViewModel(var userUseCase: GetIUserUseCase) : ViewModel() {


    fun hitAPI()
    {
        GlobalScope.launch {
            userUseCase.invoke()
        }
    }
}