package com.test.luxcarservice.app.presentation.screen.add_product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.luxcarservice.domain.model.Product
import com.test.luxcarservice.domain.use_case.GetLastProductFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetProductsFromDbUseCase
import com.test.luxcarservice.domain.use_case.SaveProductToDbUseCase
import kotlinx.coroutines.launch

class AddProductViewModel(
    private val getProductsFromDbUseCase: GetProductsFromDbUseCase,
    private val getLastProductFromDbUseCase: GetLastProductFromDbUseCase,
    private val saveProductToDbUseCase: SaveProductToDbUseCase,
): ViewModel() {

    fun getLastProductId(): Long {
        return if (getProductsFromDbUseCase.execute().isNotEmpty()) {
            getLastProductFromDbUseCase.execute().id
        } else {
            0L
        }
    }

    fun upsertProduct(product: Product) {
        viewModelScope.launch {
            saveProductToDbUseCase.execute(product = product)
        }
    }
}