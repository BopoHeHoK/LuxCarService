package com.test.luxcarservice.app.presentation.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.domain.use_case.SetUserIdToSharedPrefsUseCase

class ProfileViewModelFactory(
    private val setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel(
            setUserIdToSharedPrefsUseCase = setUserIdToSharedPrefsUseCase,
        ) as T
    }
}