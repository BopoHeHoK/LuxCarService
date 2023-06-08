package com.test.luxcarservice.app.presentation.screen.services

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.domain.use_case.GetServicesFromDbUseCase

class ServicesViewModelFactory(
    private val getServicesFromDbUseCase: GetServicesFromDbUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ServicesViewModel(
            getServicesFromDbUseCase = getServicesFromDbUseCase,
        ) as T
    }
}