package com.test.luxcarservice.app.presentation.screen.notifications

import androidx.lifecycle.ViewModel
import com.test.luxcarservice.domain.model.Notification
import com.test.luxcarservice.domain.use_case.GetNotificationsFromDbUseCase

class NotificationsViewModel(
    private val getNotificationsFromDbUseCase: GetNotificationsFromDbUseCase,
) : ViewModel() {

    fun getNotifications(): List<Notification> {
        return getNotificationsFromDbUseCase.execute()
    }
}