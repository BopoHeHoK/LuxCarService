package com.test.luxcarservice.app.presentation.screen.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.domain.use_case.CheckUserEmailUseCase
import com.test.luxcarservice.domain.use_case.GetLastUserFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetUsersFromDbUseCase
import com.test.luxcarservice.domain.use_case.SaveUserToDbUseCase
import com.test.luxcarservice.domain.use_case.SetUserIdToSharedPrefsUseCase

class SignUpViewModelFactory(
    private val getUsersFromDbUseCase: GetUsersFromDbUseCase,
    private val getLastUserFromDbUseCase: GetLastUserFromDbUseCase,
    private val checkUserEmailUseCase: CheckUserEmailUseCase,
    private val setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,
    private val saveUserToDbUseCase: SaveUserToDbUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignUpViewModel(
            getUsersFromDbUseCase = getUsersFromDbUseCase,
            getLastUserFromDbUseCase = getLastUserFromDbUseCase,
            checkUserEmailUseCase = checkUserEmailUseCase,
            setUserIdToSharedPrefsUseCase = setUserIdToSharedPrefsUseCase,
            saveUserToDbUseCase = saveUserToDbUseCase,
        ) as T
    }
}