package com.test.luxcarservice.app.presentation.screen.appointments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AppointmentsViewModelFactory(

) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AppointmentsViewModel(

        ) as T
    }
}