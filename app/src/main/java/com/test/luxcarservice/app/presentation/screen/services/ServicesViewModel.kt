package com.test.luxcarservice.app.presentation.screen.services

import androidx.lifecycle.ViewModel
import com.test.luxcarservice.domain.model.Service
import com.test.luxcarservice.domain.use_case.GetServicesFromDbUseCase

class ServicesViewModel(
    private val getServicesFromDbUseCase: GetServicesFromDbUseCase,
) : ViewModel() {

    fun getServices(): List<Service> {
        return getServicesFromDbUseCase.execute()
    }
}