package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.Notification

class GetLastNotificationFromDbUseCase(private val userRepository: UserRepository) {

    fun execute(): Notification {
        return userRepository.getLastNotificationFromDb()
    }
}