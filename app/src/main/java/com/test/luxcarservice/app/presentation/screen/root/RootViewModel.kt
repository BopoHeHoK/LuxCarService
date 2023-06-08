package com.test.luxcarservice.app.presentation.screen.root

import androidx.lifecycle.ViewModel
import com.test.luxcarservice.domain.use_case.SetUserIdToSharedPrefsUseCase

class RootViewModel(
    private val setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,
) : ViewModel() {

    fun deleteUserId() {
        setUserIdToSharedPrefsUseCase.execute(userId = 0L)
    }
}