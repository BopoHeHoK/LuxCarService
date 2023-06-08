package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.Product

class GetProductsFromDbUseCase(private val userRepository: UserRepository) {

    fun execute(): List<Product> {
        return userRepository.getProductsFromDb()
    }
}