package com.test.luxcarservice.app.presentation.screen.add_service

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddServiceViewModelFactory(

) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddServiceViewModel(

        ) as T
    }
}