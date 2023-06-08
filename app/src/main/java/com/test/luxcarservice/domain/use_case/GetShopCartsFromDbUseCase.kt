package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.ShopCart

class GetShopCartsFromDbUseCase(private val userRepository: UserRepository) {

    fun execute(): List<ShopCart> {
        return userRepository.getShopCartsFromDb()
    }
}