package com.test.luxcarservice.app.presentation.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.luxcarservice.domain.model.Product
import com.test.luxcarservice.domain.model.Role
import com.test.luxcarservice.domain.model.Service
import com.test.luxcarservice.domain.use_case.GetUserIdFromSharedPrefsUseCase
import com.test.luxcarservice.domain.use_case.SaveProductToDbUseCase
import com.test.luxcarservice.domain.use_case.SaveRoleToDbUseCase
import com.test.luxcarservice.domain.use_case.SaveServiceToDbUseCase
import kotlinx.coroutines.launch

class SplashViewModel(
    private val saveRoleToDbUseCase: SaveRoleToDbUseCase,
    private val saveServiceToDbUseCase: SaveServiceToDbUseCase,
    private val saveProductToDbUseCase: SaveProductToDbUseCase,
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
) : ViewModel() {

    fun upsertRole(role: Role) {
        viewModelScope.launch {
            saveRoleToDbUseCase.execute(role = role)
        }
    }

    fun upsertService(service: Service) {
        viewModelScope.launch {
            saveServiceToDbUseCase.execute(service = service)
        }
    }

    fun upsertProduct(product: Product) {
        viewModelScope.launch {
            saveProductToDbUseCase.execute(product = product)
        }
    }

    fun getUserId(): Long {
        return getUserIdFromSharedPrefsUseCase.execute()
    }
}