package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.Service

class GetLastServiceFromDbUseCase(private val userRepository: UserRepository) {

    fun execute(): Service {
        return userRepository.getLastServiceFromDb()
    }
}