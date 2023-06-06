package com.test.luxcarservice.app.presentation.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SplashViewModelFactory(

) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SplashViewModel(

        ) as T
    }
}