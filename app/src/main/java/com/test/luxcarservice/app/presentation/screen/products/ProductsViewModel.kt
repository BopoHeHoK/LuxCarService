package com.test.luxcarservice.app.presentation.screen.products

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.luxcarservice.domain.model.Appointment
import com.test.luxcarservice.domain.model.Product
import com.test.luxcarservice.domain.model.Role
import com.test.luxcarservice.domain.model.ShopCart
import com.test.luxcarservice.domain.model.User
import com.test.luxcarservice.domain.use_case.DeleteProductByIdFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetLastShopCartFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetProductsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetRolesFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetShopCartsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetUserFromDbByIdUseCase
import com.test.luxcarservice.domain.use_case.GetUserIdFromSharedPrefsUseCase
import com.test.luxcarservice.domain.use_case.SaveProductToDbUseCase
import com.test.luxcarservice.domain.use_case.SaveShopCartToDbUseCase
import kotlinx.coroutines.launch

class ProductsViewModel(
    private val getProductsFromDbUseCase: GetProductsFromDbUseCase,
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getRolesFromDbUseCase: GetRolesFromDbUseCase,
    private val getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
    private val getShopCartsFromDbUseCase: GetShopCartsFromDbUseCase,
    private val getLastShopCartFromDbUseCase: GetLastShopCartFromDbUseCase,
    private val saveShopCartToDbUseCase: SaveShopCartToDbUseCase,
    private val deleteProductByIdFromDbUseCase: DeleteProductByIdFromDbUseCase,
) : ViewModel() {

    fun getProducts(): List<Product> {
        return getProductsFromDbUseCase.execute()
    }

    fun getUserId(): Long {
        return getUserIdFromSharedPrefsUseCase.execute()
    }

    fun getRoles(): List<Role> {
        return getRolesFromDbUseCase.execute()
    }

    fun getUser(userId: Long): User {
        return getUserFromDbByIdUseCase.execute(userId = userId)
    }

    fun getLastShopCart(): Long {
        return if (getShopCartsFromDbUseCase.execute().isNotEmpty()) {
            getLastShopCartFromDbUseCase.execute().id
        } else {
            0L
        }
    }

    fun upsertShopCart(shopCart: ShopCart) {
        viewModelScope.launch {
            saveShopCartToDbUseCase.execute(shopCart = shopCart)
        }
    }

    fun deleteProduct(productId: Long) {
        viewModelScope.launch {
            deleteProductByIdFromDbUseCase.execute(productId = productId)
        }
    }
}