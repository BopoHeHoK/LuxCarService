package com.test.luxcarservice.app.presentation.screen.profile_settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.domain.use_case.GetUserFromDbByIdUseCase
import com.test.luxcarservice.domain.use_case.GetUserIdFromSharedPrefsUseCase
import com.test.luxcarservice.domain.use_case.SaveUserToDbUseCase

class ProfileSettingsViewModelFactory(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
    private val saveUserToDbUseCase: SaveUserToDbUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProfileSettingsViewModel(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getUserFromDbByIdUseCase = getUserFromDbByIdUseCase,
            saveUserToDbUseCase = saveUserToDbUseCase,
        ) as T
    }
}