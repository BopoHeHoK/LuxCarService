package com.test.luxcarservice.app.presentation.screen.signin

import androidx.lifecycle.ViewModel
import com.test.luxcarservice.domain.model.User
import com.test.luxcarservice.domain.use_case.CheckUserEmailAndPasswordUseCase
import com.test.luxcarservice.domain.use_case.GetUserFromDbByEmailUseCase
import com.test.luxcarservice.domain.use_case.SetUserIdToSharedPrefsUseCase

class SignInViewModel(
    private val checkUserEmailAndPasswordUseCase: CheckUserEmailAndPasswordUseCase,
    private val getUserFromDbByEmailUseCase: GetUserFromDbByEmailUseCase,
    private val setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,
) : ViewModel() {

    fun checkEmailAndPassword(email: String, password: String): Boolean {
        return checkUserEmailAndPasswordUseCase.execute(email = email, password = password)
    }

    fun getUser(email: String): User {
        return getUserFromDbByEmailUseCase.execute(email = email)
    }

    fun setUserId(userId: Long) {
        setUserIdToSharedPrefsUseCase.execute(userId = userId)
    }
}