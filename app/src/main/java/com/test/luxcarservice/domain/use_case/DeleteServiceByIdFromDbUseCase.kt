package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository

class DeleteServiceByIdFromDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(serviceId: Long) {
        return userRepository.deleteServiceByIdFromDbUseCase(serviceId = serviceId)
    }
}