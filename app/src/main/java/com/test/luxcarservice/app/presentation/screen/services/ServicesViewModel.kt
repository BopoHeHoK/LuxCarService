package com.test.luxcarservice.app.presentation.screen.services

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.luxcarservice.domain.model.Appointment
import com.test.luxcarservice.domain.model.Role
import com.test.luxcarservice.domain.model.Service
import com.test.luxcarservice.domain.model.User
import com.test.luxcarservice.domain.use_case.DeleteServiceByIdFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetAppointmentsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetLastAppointmentFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetRolesFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetServicesFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetUserFromDbByIdUseCase
import com.test.luxcarservice.domain.use_case.GetUserIdFromSharedPrefsUseCase
import com.test.luxcarservice.domain.use_case.SaveAppointmentToDbUseCase
import kotlinx.coroutines.launch

class ServicesViewModel(
    private val getServicesFromDbUseCase: GetServicesFromDbUseCase,
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getRolesFromDbUseCase: GetRolesFromDbUseCase,
    private val getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
    private val getAppointmentsFromDbUseCase: GetAppointmentsFromDbUseCase,
    private val getLastAppointmentFromDbUseCase: GetLastAppointmentFromDbUseCase,
    private val saveAppointmentToDbUseCase: SaveAppointmentToDbUseCase,
    private val deleteServiceByIdFromDbUseCase: DeleteServiceByIdFromDbUseCase,
) : ViewModel() {

    fun getServices(): List<Service> {
        return getServicesFromDbUseCase.execute()
    }

    fun getUserId(): Long {
        return getUserIdFromSharedPrefsUseCase.execute()
    }

    fun getRoles(): List<Role> {
        return getRolesFromDbUseCase.execute()
    }

    fun getUser(userId: Long): User {
        return getUserFromDbByIdUseCase.execute(userId = userId)
    }

    fun getLastAppointment(): Long {
        return if (getAppointmentsFromDbUseCase.execute().isNotEmpty()) {
            getLastAppointmentFromDbUseCase.execute().id
        } else {
            0L
        }
    }

    fun upsertAppointment(appointment: Appointment) {
        viewModelScope.launch {
            saveAppointmentToDbUseCase.execute(appointment = appointment)
        }
    }

    fun deleteService(serviceId: Long) {
        viewModelScope.launch {
            deleteServiceByIdFromDbUseCase.execute(serviceId = serviceId)
        }
    }
}