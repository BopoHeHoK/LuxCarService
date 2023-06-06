package com.test.luxcarservice.app.presentation.screen.signin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SignInViewModelFactory(

) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignInViewModel(

        ) as T
    }
}