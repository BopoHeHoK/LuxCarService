package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.Service

class SaveServiceToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(service: Service) {
        return userRepository.saveService(service = service)
    }
}