package com.test.luxcarservice.app.presentation.screen.add_service

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.domain.use_case.GetLastServiceFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetServicesFromDbUseCase
import com.test.luxcarservice.domain.use_case.SaveServiceToDbUseCase

class AddServiceViewModelFactory(
    private val getServicesFromDbUseCase: GetServicesFromDbUseCase,
    private val getLastServiceFromDbUseCase: GetLastServiceFromDbUseCase,
    private val saveServiceToDbUseCase: SaveServiceToDbUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AddServiceViewModel(
            getServicesFromDbUseCase = getServicesFromDbUseCase,
            getLastServiceFromDbUseCase = getLastServiceFromDbUseCase,
            saveServiceToDbUseCase = saveServiceToDbUseCase,
        ) as T
    }
}