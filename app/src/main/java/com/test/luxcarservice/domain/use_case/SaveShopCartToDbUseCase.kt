package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.ShopCart

class SaveShopCartToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(shopCart: ShopCart) {
        return userRepository.saveShopCart(shopCart = shopCart)
    }
}