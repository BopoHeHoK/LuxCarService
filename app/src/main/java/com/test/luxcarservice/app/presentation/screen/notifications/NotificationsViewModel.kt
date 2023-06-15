package com.test.luxcarservice.app.presentation.screen.notifications

import androidx.lifecycle.ViewModel
import com.test.luxcarservice.domain.model.Appointment
import com.test.luxcarservice.domain.model.Notification
import com.test.luxcarservice.domain.model.Product
import com.test.luxcarservice.domain.model.Role
import com.test.luxcarservice.domain.model.Service
import com.test.luxcarservice.domain.model.ShopCart
import com.test.luxcarservice.domain.model.User
import com.test.luxcarservice.domain.use_case.GetAppointmentsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetNotificationsByUserIdFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetNotificationsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetProductsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetRolesFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetServicesFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetShopCartsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetUserFromDbByIdUseCase
import com.test.luxcarservice.domain.use_case.GetUserIdFromSharedPrefsUseCase
import com.test.luxcarservice.domain.use_case.GetUsersFromDbUseCase

class NotificationsViewModel(
    private val getNotificationsFromDbUseCase: GetNotificationsFromDbUseCase,
    private val getNotificationsByUserIdFromDbUseCase: GetNotificationsByUserIdFromDbUseCase,
    private val getAppointmentsFromDbUseCase: GetAppointmentsFromDbUseCase,
    private val getShopCartsFromDbUseCase: GetShopCartsFromDbUseCase,
    private val getServicesFromDbUseCase: GetServicesFromDbUseCase,
    private val getProductsFromDbUseCase: GetProductsFromDbUseCase,
    private val getUsersFromDbUseCase: GetUsersFromDbUseCase,
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getRolesFromDbUseCase: GetRolesFromDbUseCase,
    private val getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
) : ViewModel() {

    fun getNotifications(): List<Notification> {
        return getNotificationsFromDbUseCase.execute()
    }

    fun getNotificationsByUserId(userId: Long): List<Notification> {
        return getNotificationsByUserIdFromDbUseCase.execute(userId = userId)
    }

    fun getAppointments(): List<Appointment> {
        return getAppointmentsFromDbUseCase.execute()
    }

    fun getOrders(): List<ShopCart> {
        return getShopCartsFromDbUseCase.execute()
    }

    fun getServices(): List<Service> {
        return getServicesFromDbUseCase.execute()
    }

    fun getProducts(): List<Product> {
        return getProductsFromDbUseCase.execute()
    }

    fun getUsers(): List<User> {
        return getUsersFromDbUseCase.execute()
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
}