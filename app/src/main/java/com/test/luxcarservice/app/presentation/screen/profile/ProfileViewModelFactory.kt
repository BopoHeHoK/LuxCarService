package com.test.luxcarservice.app.presentation.screen.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.domain.use_case.GetUserFromDbByIdUseCase
import com.test.luxcarservice.domain.use_case.GetUserIdFromSharedPrefsUseCase
import com.test.luxcarservice.domain.use_case.SetUserIdToSharedPrefsUseCase

class ProfileViewModelFactory(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,
    private val getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileViewModel(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            setUserIdToSharedPrefsUseCase = setUserIdToSharedPrefsUseCase,
            getUserFromDbByIdUseCase = getUserFromDbByIdUseCase,
        ) as T
    }
}