package com.test.luxcarservice.app.presentation.screen.information

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class InformationViewModelFactory(

) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return InformationViewModel(

        ) as T
    }
}