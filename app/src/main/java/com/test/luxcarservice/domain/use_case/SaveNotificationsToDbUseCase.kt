package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.Notification

class SaveNotificationsToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(notification: Notification) {
        return userRepository.saveNotification(notification = notification)
    }
}