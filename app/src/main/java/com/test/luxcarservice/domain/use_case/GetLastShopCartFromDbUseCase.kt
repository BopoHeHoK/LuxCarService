package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.ShopCart

class GetLastShopCartFromDbUseCase(private val userRepository: UserRepository) {

    fun execute(): ShopCart {
        return userRepository.getLastShopCartFromDb()
    }
}