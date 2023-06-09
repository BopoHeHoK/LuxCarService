package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.ShopCart

class GetShopCartsByUserIdFromDbUseCase(private val userRepository: UserRepository) {

    fun execute(userId: Long): List<ShopCart> {
        return userRepository.getShopCartsByUserIdFromDb(userId = userId)
    }
}