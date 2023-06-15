package com.test.luxcarservice.app.presentation.screen.add_product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.domain.use_case.GetLastProductFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetProductsFromDbUseCase
import com.test.luxcarservice.domain.use_case.SaveProductToDbUseCase

class AddProductViewModelFactory(
    private val getProductsFromDbUseCase: GetProductsFromDbUseCase,
    private val getLastProductFromDbUseCase: GetLastProductFromDbUseCase,
    private val saveProductToDbUseCase: SaveProductToDbUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddProductViewModel(
            getProductsFromDbUseCase = getProductsFromDbUseCase,
            getLastProductFromDbUseCase = getLastProductFromDbUseCase,
            saveProductToDbUseCase = saveProductToDbUseCase,
        ) as T
    }
}