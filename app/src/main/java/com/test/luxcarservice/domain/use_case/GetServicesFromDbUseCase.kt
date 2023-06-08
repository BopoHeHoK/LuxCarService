package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.Service

class GetServicesFromDbUseCase(private val userRepository: UserRepository) {

    fun execute(): List<Service> {
        return userRepository.getServicesFromDb()
    }
}