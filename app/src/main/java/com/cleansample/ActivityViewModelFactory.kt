package com.cleansample

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.domain.usecase.GetIUserUseCase
import javax.inject.Inject

class ActivityViewModelFactory @Inject constructor(var userIUserUseCase: GetIUserUseCase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ActivityViewModel(userIUserUseCase) as T
    }
}