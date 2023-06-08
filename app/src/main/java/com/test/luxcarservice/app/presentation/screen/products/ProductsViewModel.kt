package com.test.luxcarservice.app.presentation.screen.products

import androidx.lifecycle.ViewModel
import com.test.luxcarservice.domain.model.Product
import com.test.luxcarservice.domain.use_case.GetProductsFromDbUseCase

class ProductsViewModel(
    private val getProductsFromDbUseCase: GetProductsFromDbUseCase,
) : ViewModel() {

    fun getProducts(): List<Product> {
        return getProductsFromDbUseCase.execute()
    }
}