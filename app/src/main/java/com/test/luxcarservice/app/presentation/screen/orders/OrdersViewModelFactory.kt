package com.test.luxcarservice.app.presentation.screen.orders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.domain.use_case.GetShopCartsFromDbUseCase

class OrdersViewModelFactory(
    private val getShopCartsFromDbUseCase: GetShopCartsFromDbUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return OrdersViewModel(
            getShopCartsFromDbUseCase = getShopCartsFromDbUseCase,
        ) as T
    }
}