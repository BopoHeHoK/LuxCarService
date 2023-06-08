package com.test.luxcarservice.app.presentation.screen.profile

import androidx.lifecycle.ViewModel
import com.test.luxcarservice.domain.use_case.SetUserIdToSharedPrefsUseCase

class ProfileViewModel(
    private val setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,
) : ViewModel() {

    fun deleteUserId() {
        setUserIdToSharedPrefsUseCase.execute(userId = 0L)
    }
}