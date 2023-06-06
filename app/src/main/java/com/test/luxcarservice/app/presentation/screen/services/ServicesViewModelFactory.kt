package com.test.luxcarservice.app.presentation.screen.services

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ServicesViewModelFactory(

) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ServicesViewModel(

        ) as T
    }
}