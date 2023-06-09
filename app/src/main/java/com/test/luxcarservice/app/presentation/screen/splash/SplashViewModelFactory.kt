package com.test.luxcarservice.app.presentation.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.domain.use_case.GetUserIdFromSharedPrefsUseCase
import com.test.luxcarservice.domain.use_case.SaveProductToDbUseCase
import com.test.luxcarservice.domain.use_case.SaveRoleToDbUseCase
import com.test.luxcarservice.domain.use_case.SaveServiceToDbUseCase

class SplashViewModelFactory(
    private val saveRoleToDbUseCase: SaveRoleToDbUseCase,
    private val saveServiceToDbUseCase: SaveServiceToDbUseCase,
    private val saveProductToDbUseCase: SaveProductToDbUseCase,
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SplashViewModel(
            saveRoleToDbUseCase = saveRoleToDbUseCase,
            saveServiceToDbUseCase = saveServiceToDbUseCase,
            saveProductToDbUseCase = saveProductToDbUseCase,
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
        ) as T
    }
}