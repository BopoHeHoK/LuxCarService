package com.test.luxcarservice.app.presentation.screen.orders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.domain.use_case.GetProductsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetRolesFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetShopCartsByUserIdFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetShopCartsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetUserFromDbByIdUseCase
import com.test.luxcarservice.domain.use_case.GetUserIdFromSharedPrefsUseCase
import com.test.luxcarservice.domain.use_case.GetUsersFromDbUseCase

class OrdersViewModelFactory(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getShopCartsFromDbUseCase: GetShopCartsFromDbUseCase,
    private val getShopCartsByUserIdFromDbUseCase: GetShopCartsByUserIdFromDbUseCase,
    private val getRolesFromDbUseCase: GetRolesFromDbUseCase,
    private val getProductsFromDbUseCase: GetProductsFromDbUseCase,
    private val getUsersFromDbUseCase: GetUsersFromDbUseCase,
    private val getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return OrdersViewModel(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getShopCartsFromDbUseCase = getShopCartsFromDbUseCase,
            getShopCartsByUserIdFromDbUseCase = getShopCartsByUserIdFromDbUseCase,
            getRolesFromDbUseCase = getRolesFromDbUseCase,
            getProductsFromDbUseCase = getProductsFromDbUseCase,
            getUsersFromDbUseCase = getUsersFromDbUseCase,
            getUserFromDbByIdUseCase = getUserFromDbByIdUseCase,
        ) as T
    }
}