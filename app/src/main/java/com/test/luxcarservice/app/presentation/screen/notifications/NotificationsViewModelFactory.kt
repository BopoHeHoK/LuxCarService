package com.test.luxcarservice.app.presentation.screen.notifications

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.domain.use_case.GetAppointmentsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetNotificationsByUserIdFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetNotificationsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetRolesFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetShopCartsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetUserFromDbByIdUseCase
import com.test.luxcarservice.domain.use_case.GetUserIdFromSharedPrefsUseCase
import com.test.luxcarservice.domain.use_case.GetUsersFromDbUseCase

class NotificationsViewModelFactory(
    private val getNotificationsFromDbUseCase: GetNotificationsFromDbUseCase,
    private val getNotificationsByUserIdFromDbUseCase: GetNotificationsByUserIdFromDbUseCase,
    private val getAppointmentsFromDbUseCase: GetAppointmentsFromDbUseCase,
    private val getShopCartsFromDbUseCase: GetShopCartsFromDbUseCase,
    private val getUsersFromDbUseCase: GetUsersFromDbUseCase,
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getRolesFromDbUseCase: GetRolesFromDbUseCase,
    private val getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NotificationsViewModel(
            getNotificationsFromDbUseCase = getNotificationsFromDbUseCase,
            getNotificationsByUserIdFromDbUseCase = getNotificationsByUserIdFromDbUseCase,
            getAppointmentsFromDbUseCase = getAppointmentsFromDbUseCase,
            getShopCartsFromDbUseCase = getShopCartsFromDbUseCase,
            getUsersFromDbUseCase = getUsersFromDbUseCase,
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getRolesFromDbUseCase = getRolesFromDbUseCase,
            getUserFromDbByIdUseCase = getUserFromDbByIdUseCase,
        ) as T
    }
}