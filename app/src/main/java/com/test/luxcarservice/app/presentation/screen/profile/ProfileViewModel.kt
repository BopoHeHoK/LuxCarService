package com.test.luxcarservice.app.presentation.screen.profile

import androidx.lifecycle.ViewModel
import com.test.luxcarservice.domain.model.User
import com.test.luxcarservice.domain.use_case.GetUserFromDbByIdUseCase
import com.test.luxcarservice.domain.use_case.GetUserIdFromSharedPrefsUseCase
import com.test.luxcarservice.domain.use_case.SetUserIdToSharedPrefsUseCase

class ProfileViewModel(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,
    private val getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
) : ViewModel() {

    fun getUserId(): Long {
        return getUserIdFromSharedPrefsUseCase.execute()
    }

    fun deleteUserId() {
        setUserIdToSharedPrefsUseCase.execute(userId = 0L)
    }

    fun getUser(id: Long): User {
        return getUserFromDbByIdUseCase.execute(userId = id)
    }
}