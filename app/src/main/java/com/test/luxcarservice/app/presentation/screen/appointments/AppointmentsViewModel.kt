package com.test.luxcarservice.app.presentation.screen.appointments

import androidx.lifecycle.ViewModel
import com.test.luxcarservice.domain.model.Appointment
import com.test.luxcarservice.domain.use_case.GetAppointmentsFromDbUseCase

class AppointmentsViewModel(
    private val getAppointmentsFromDbUseCase: GetAppointmentsFromDbUseCase,
) : ViewModel() {

    fun getAppointments(): List<Appointment> {
        return getAppointmentsFromDbUseCase.execute()
    }
}