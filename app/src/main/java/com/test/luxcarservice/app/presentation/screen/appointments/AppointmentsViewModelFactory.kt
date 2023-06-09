package com.test.luxcarservice.app.presentation.screen.appointments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.domain.use_case.GetAppointmentsByUserIdFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetAppointmentsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetRolesFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetServicesFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetUserFromDbByIdUseCase
import com.test.luxcarservice.domain.use_case.GetUserIdFromSharedPrefsUseCase
import com.test.luxcarservice.domain.use_case.GetUsersFromDbUseCase

class AppointmentsViewModelFactory(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getAppointmentsFromDbUseCase: GetAppointmentsFromDbUseCase,
    private val getAppointmentsByUserIdFromDbUseCase: GetAppointmentsByUserIdFromDbUseCase,
    private val getRolesFromDbUseCase: GetRolesFromDbUseCase,
    private val getServicesFromDbUseCase: GetServicesFromDbUseCase,
    private val getUsersFromDbUseCase: GetUsersFromDbUseCase,
    private val getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AppointmentsViewModel(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getAppointmentsFromDbUseCase = getAppointmentsFromDbUseCase,
            getAppointmentsByUserIdFromDbUseCase = getAppointmentsByUserIdFromDbUseCase,
            getRolesFromDbUseCase = getRolesFromDbUseCase,
            getServicesFromDbUseCase = getServicesFromDbUseCase,
            getUsersFromDbUseCase = getUsersFromDbUseCase,
            getUserFromDbByIdUseCase = getUserFromDbByIdUseCase,
        ) as T
    }
}