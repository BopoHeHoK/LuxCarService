package com.test.luxcarservice.app.presentation.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.luxcarservice.domain.model.Role
import com.test.luxcarservice.domain.use_case.GetUserIdFromSharedPrefsUseCase
import com.test.luxcarservice.domain.use_case.SaveRoleToDbUseCase
import kotlinx.coroutines.launch

class SplashViewModel(
    private val saveRoleToDbUseCase: SaveRoleToDbUseCase,
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
) : ViewModel() {

    fun upsertRole(role: Role) {
        viewModelScope.launch {
            saveRoleToDbUseCase.execute(role = role)
        }
    }

    fun getUserId(): Long {
        return getUserIdFromSharedPrefsUseCase.execute()
    }
}