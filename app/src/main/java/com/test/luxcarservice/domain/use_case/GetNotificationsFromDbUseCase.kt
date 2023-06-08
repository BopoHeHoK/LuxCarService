package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.Notification

class GetNotificationsFromDbUseCase(private val userRepository: UserRepository) {

    fun execute(): List<Notification> {
        return userRepository.getNotificationsFromDb()
    }
}