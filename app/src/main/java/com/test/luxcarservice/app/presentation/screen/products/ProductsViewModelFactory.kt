package com.test.luxcarservice.app.presentation.screen.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.test.luxcarservice.domain.use_case.DeleteProductByIdFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetLastNotificationFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetLastShopCartFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetNotificationsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetProductsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetRolesFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetShopCartsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetUserFromDbByIdUseCase
import com.test.luxcarservice.domain.use_case.GetUserIdFromSharedPrefsUseCase
import com.test.luxcarservice.domain.use_case.SaveNotificationsToDbUseCase
import com.test.luxcarservice.domain.use_case.SaveShopCartToDbUseCase

class ProductsViewModelFactory(
    private val getProductsFromDbUseCase: GetProductsFromDbUseCase,
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getRolesFromDbUseCase: GetRolesFromDbUseCase,
    private val getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
    private val getShopCartsFromDbUseCase: GetShopCartsFromDbUseCase,
    private val getNotificationsFromDbUseCase: GetNotificationsFromDbUseCase,
    private val getLastShopCartFromDbUseCase: GetLastShopCartFromDbUseCase,
    private val getLastNotificationFromDbUseCase: GetLastNotificationFromDbUseCase,
    private val saveShopCartToDbUseCase: SaveShopCartToDbUseCase,
    private val saveNotificationsToDbUseCase: SaveNotificationsToDbUseCase,
    private val deleteProductByIdFromDbUseCase: DeleteProductByIdFromDbUseCase,
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductsViewModel(
            getProductsFromDbUseCase = getProductsFromDbUseCase,
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getRolesFromDbUseCase = getRolesFromDbUseCase,
            getUserFromDbByIdUseCase = getUserFromDbByIdUseCase,
            getShopCartsFromDbUseCase = getShopCartsFromDbUseCase,
            getNotificationsFromDbUseCase = getNotificationsFromDbUseCase,
            getLastShopCartFromDbUseCase = getLastShopCartFromDbUseCase,
            getLastNotificationFromDbUseCase = getLastNotificationFromDbUseCase,
            saveShopCartToDbUseCase = saveShopCartToDbUseCase,
            saveNotificationsToDbUseCase = saveNotificationsToDbUseCase,
            deleteProductByIdFromDbUseCase = deleteProductByIdFromDbUseCase,
        ) as T
    }
}