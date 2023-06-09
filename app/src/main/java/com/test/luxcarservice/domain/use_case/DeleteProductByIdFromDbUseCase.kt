package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository

class DeleteProductByIdFromDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(productId: Long) {
        return userRepository.deleteProductByIdFromDbUseCase(productId = productId)
    }
}