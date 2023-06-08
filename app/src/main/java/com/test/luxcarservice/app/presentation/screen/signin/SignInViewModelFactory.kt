package com.test.luxcarservice.app.presentation.screen.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.domain.use_case.CheckUserEmailAndPasswordUseCase
import com.test.luxcarservice.domain.use_case.GetUserFromDbByEmailUseCase
import com.test.luxcarservice.domain.use_case.SetUserIdToSharedPrefsUseCase

class SignInViewModelFactory(
    private val checkUserEmailAndPasswordUseCase: CheckUserEmailAndPasswordUseCase,
    private val getUserFromDbByEmailUseCase: GetUserFromDbByEmailUseCase,
    private val setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignInViewModel(
            checkUserEmailAndPasswordUseCase = checkUserEmailAndPasswordUseCase,
            getUserFromDbByEmailUseCase = getUserFromDbByEmailUseCase,
            setUserIdToSharedPrefsUseCase = setUserIdToSharedPrefsUseCase,
        ) as T
    }
}