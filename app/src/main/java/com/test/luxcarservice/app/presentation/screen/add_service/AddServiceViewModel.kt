package com.test.luxcarservice.app.presentation.screen.add_service

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.luxcarservice.domain.model.Service
import com.test.luxcarservice.domain.use_case.GetLastServiceFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetServicesFromDbUseCase
import com.test.luxcarservice.domain.use_case.SaveServiceToDbUseCase
import kotlinx.coroutines.launch

class AddServiceViewModel(
    private val getServicesFromDbUseCase: GetServicesFromDbUseCase,
    private val getLastServiceFromDbUseCase: GetLastServiceFromDbUseCase,
    private val saveServiceToDbUseCase: SaveServiceToDbUseCase,
): ViewModel() {

    fun getLastServiceId(): Long {
        return if (getServicesFromDbUseCase.execute().isNotEmpty()) {
            getLastServiceFromDbUseCase.execute().id
        } else {
            0L
        }
    }

    fun upsertService(service: Service) {
        viewModelScope.launch {
            saveServiceToDbUseCase.execute(service = service)
        }
    }
}