package com.test.luxcarservice.app.presentation.screen.orders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class OrdersViewModelFactory(

) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return OrdersViewModel(

        ) as T
    }
}