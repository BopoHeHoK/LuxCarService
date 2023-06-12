package com.test.luxcarservice.app.presentation.screen.add_product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class AddProductViewModelFactory(

) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddProductViewModel(

        ) as T
    }
}