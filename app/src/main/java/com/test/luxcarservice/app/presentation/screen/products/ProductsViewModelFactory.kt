package com.test.luxcarservice.app.presentation.screen.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ProductsViewModelFactory(

) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductsViewModel(

        ) as T
    }
}