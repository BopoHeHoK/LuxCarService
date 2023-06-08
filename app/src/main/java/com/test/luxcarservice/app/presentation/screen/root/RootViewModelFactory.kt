package com.test.luxcarservice.app.presentation.screen.root

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.domain.use_case.SetUserIdToSharedPrefsUseCase

class RootViewModelFactory(
    private val setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return RootViewModel(
            setUserIdToSharedPrefsUseCase = setUserIdToSharedPrefsUseCase,
        ) as T
    }
}