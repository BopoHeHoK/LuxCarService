package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.Product

class SaveProductToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(product: Product) {
        return userRepository.saveProduct(product = product)
    }
}