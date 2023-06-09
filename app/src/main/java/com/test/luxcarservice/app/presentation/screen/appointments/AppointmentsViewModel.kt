package com.test.luxcarservice.app.presentation.screen.appointments

import androidx.lifecycle.ViewModel
import com.test.luxcarservice.domain.model.Appointment
import com.test.luxcarservice.domain.model.Product
import com.test.luxcarservice.domain.model.Role
import com.test.luxcarservice.domain.model.Service
import com.test.luxcarservice.domain.model.User
import com.test.luxcarservice.domain.use_case.GetAppointmentsByUserIdFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetAppointmentsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetRolesFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetServicesFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetUserFromDbByIdUseCase
import com.test.luxcarservice.domain.use_case.GetUserIdFromSharedPrefsUseCase
import com.test.luxcarservice.domain.use_case.GetUsersFromDbUseCase

class AppointmentsViewModel(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getAppointmentsFromDbUseCase: GetAppointmentsFromDbUseCase,
    private val getAppointmentsByUserIdFromDbUseCase: GetAppointmentsByUserIdFromDbUseCase,
    private val getRolesFromDbUseCase: GetRolesFromDbUseCase,
    private val getServicesFromDbUseCase: GetServicesFromDbUseCase,
    private val getUsersFromDbUseCase: GetUsersFromDbUseCase,
    private val getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
) : ViewModel() {

    fun getUserId(): Long {
        return getUserIdFromSharedPrefsUseCase.execute()
    }

    fun getAppointments(): List<Appointment> {
        return getAppointmentsFromDbUseCase.execute()
    }

    fun getUserAppointments(userId: Long): List<Appointment> {
        return getAppointmentsByUserIdFromDbUseCase.execute(userId = userId)
    }

    fun getRoles(): List<Role> {
        return getRolesFromDbUseCase.execute()
    }

    fun getServices(): List<Service> {
        return getServicesFromDbUseCase.execute()
    }

    fun getUsers(): List<User> {
        return getUsersFromDbUseCase.execute()
    }

    fun getUser(userId: Long): User {
        return getUserFromDbByIdUseCase.execute(userId = userId)
    }
}