package com.test.luxcarservice.app.presentation.screen.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.domain.use_case.GetProductsFromDbUseCase

class ProductsViewModelFactory(
    private val getProductsFromDbUseCase: GetProductsFromDbUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductsViewModel(
            getProductsFromDbUseCase = getProductsFromDbUseCase,
        ) as T
    }
}