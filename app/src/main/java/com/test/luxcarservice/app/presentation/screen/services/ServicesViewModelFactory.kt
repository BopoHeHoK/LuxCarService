package com.test.luxcarservice.app.presentation.screen.services

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.domain.use_case.DeleteServiceByIdFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetAppointmentsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetLastAppointmentFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetLastNotificationFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetNotificationsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetRolesFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetServicesFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetUserFromDbByIdUseCase
import com.test.luxcarservice.domain.use_case.GetUserIdFromSharedPrefsUseCase
import com.test.luxcarservice.domain.use_case.SaveAppointmentToDbUseCase
import com.test.luxcarservice.domain.use_case.SaveNotificationsToDbUseCase

class ServicesViewModelFactory(
    private val getServicesFromDbUseCase: GetServicesFromDbUseCase,
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getRolesFromDbUseCase: GetRolesFromDbUseCase,
    private val getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
    private val getAppointmentsFromDbUseCase: GetAppointmentsFromDbUseCase,
    private val getNotificationsFromDbUseCase: GetNotificationsFromDbUseCase,
    private val getLastAppointmentFromDbUseCase: GetLastAppointmentFromDbUseCase,
    private val getLastNotificationFromDbUseCase: GetLastNotificationFromDbUseCase,
    private val saveAppointmentToDbUseCase: SaveAppointmentToDbUseCase,
    private val saveNotificationsToDbUseCase: SaveNotificationsToDbUseCase,
    private val deleteServiceByIdFromDbUseCase: DeleteServiceByIdFromDbUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ServicesViewModel(
            getServicesFromDbUseCase = getServicesFromDbUseCase,
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getRolesFromDbUseCase = getRolesFromDbUseCase,
            getUserFromDbByIdUseCase = getUserFromDbByIdUseCase,
            getAppointmentsFromDbUseCase = getAppointmentsFromDbUseCase,
            getNotificationsFromDbUseCase = getNotificationsFromDbUseCase,
            getLastAppointmentFromDbUseCase = getLastAppointmentFromDbUseCase,
            getLastNotificationFromDbUseCase = getLastNotificationFromDbUseCase,
            saveAppointmentToDbUseCase = saveAppointmentToDbUseCase,
            saveNotificationsToDbUseCase = saveNotificationsToDbUseCase,
            deleteServiceByIdFromDbUseCase = deleteServiceByIdFromDbUseCase,
        ) as T
    }
}