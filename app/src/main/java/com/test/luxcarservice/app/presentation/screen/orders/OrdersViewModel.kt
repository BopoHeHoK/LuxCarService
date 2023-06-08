package com.test.luxcarservice.app.presentation.screen.orders

import androidx.lifecycle.ViewModel
import com.test.luxcarservice.domain.model.ShopCart
import com.test.luxcarservice.domain.use_case.GetShopCartsFromDbUseCase

class OrdersViewModel(
    private val getShopCartsFromDbUseCase: GetShopCartsFromDbUseCase,
) : ViewModel() {

    fun getOrders(): List<ShopCart> {
        return getShopCartsFromDbUseCase.execute()
    }
}