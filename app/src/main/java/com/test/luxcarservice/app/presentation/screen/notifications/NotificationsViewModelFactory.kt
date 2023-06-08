package com.test.luxcarservice.app.presentation.screen.notifications

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.domain.use_case.GetNotificationsFromDbUseCase

class NotificationsViewModelFactory(
    private val getNotificationsFromDbUseCase: GetNotificationsFromDbUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NotificationsViewModel(
            getNotificationsFromDbUseCase = getNotificationsFromDbUseCase,
        ) as T
    }
}