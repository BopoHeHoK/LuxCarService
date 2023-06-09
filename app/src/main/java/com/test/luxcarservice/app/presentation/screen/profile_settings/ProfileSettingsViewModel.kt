package com.test.luxcarservice.app.presentation.screen.profile_settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.luxcarservice.domain.model.User
import com.test.luxcarservice.domain.use_case.GetUserFromDbByIdUseCase
import com.test.luxcarservice.domain.use_case.GetUserIdFromSharedPrefsUseCase
import com.test.luxcarservice.domain.use_case.SaveUserToDbUseCase
import kotlinx.coroutines.launch

class ProfileSettingsViewModel(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
    private val saveUserToDbUseCase: SaveUserToDbUseCase,
) : ViewModel() {
    fun getUserId(): Long {
        return getUserIdFromSharedPrefsUseCase.execute()
    }

    fun getUser(id: Long): User {
        return getUserFromDbByIdUseCase.execute(userId = id)
    }

    fun upsertUser(user: User) {
        viewModelScope.launch {
            saveUserToDbUseCase.execute(user = user)
        }
    }
}