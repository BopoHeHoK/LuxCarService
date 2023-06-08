package com.test.luxcarservice.app.presentation.screen.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.luxcarservice.domain.model.User
import com.test.luxcarservice.domain.use_case.CheckUserEmailUseCase
import com.test.luxcarservice.domain.use_case.GetLastUserFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetUsersFromDbUseCase
import com.test.luxcarservice.domain.use_case.SaveUserToDbUseCase
import com.test.luxcarservice.domain.use_case.SetUserIdToSharedPrefsUseCase
import kotlinx.coroutines.launch

class SignUpViewModel(
    private val getUsersFromDbUseCase: GetUsersFromDbUseCase,
    private val getLastUserFromDbUseCase: GetLastUserFromDbUseCase,
    private val checkUserEmailUseCase: CheckUserEmailUseCase,
    private val setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,
    private val saveUserToDbUseCase: SaveUserToDbUseCase,
) : ViewModel() {

    fun getLastUser(): Long {
        if (getUsersFromDbUseCase.execute().isNotEmpty()) {
            return getLastUserFromDbUseCase.execute().id
        } else {
            return 0L
        }
    }

    fun checkEmail(email: String): Boolean {
        return checkUserEmailUseCase.execute(email = email)
    }

    fun setUserId(userId: Long) {
        setUserIdToSharedPrefsUseCase.execute(userId = userId)
    }

    fun upsertUser(user: User) {
        viewModelScope.launch {
            saveUserToDbUseCase.execute(user = user)
        }
    }
}