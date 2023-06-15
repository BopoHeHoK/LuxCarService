package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.Product

class GetLastProductFromDbUseCase(private val userRepository: UserRepository) {

    fun execute(): Product {
        return userRepository.getLastProductFromDb()
    }
}