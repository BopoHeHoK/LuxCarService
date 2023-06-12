package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.Appointment
import com.test.luxcarservice.domain.model.Notification

class GetNotificationsByUserIdFromDbUseCase(private val userRepository: UserRepository) {

    fun execute(userId: Long): List<Notification> {
        return userRepository.getNotificationsByUserIdFromDb(userId = userId)
    }
}