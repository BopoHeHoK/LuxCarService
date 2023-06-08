package com.test.luxcarservice.app.presentation.screen.appointments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.domain.use_case.GetAppointmentsFromDbUseCase

class AppointmentsViewModelFactory(
    private val getAppointmentsFromDbUseCase: GetAppointmentsFromDbUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AppointmentsViewModel(
            getAppointmentsFromDbUseCase = getAppointmentsFromDbUseCase,
        ) as T
    }
}