package com.test.luxcarservice.app.presentation.screen.orders

import androidx.lifecycle.ViewModel
import com.test.luxcarservice.domain.model.Product
import com.test.luxcarservice.domain.model.Role
import com.test.luxcarservice.domain.model.ShopCart
import com.test.luxcarservice.domain.model.User
import com.test.luxcarservice.domain.use_case.GetProductsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetRolesFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetShopCartsByUserIdFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetShopCartsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetUserFromDbByIdUseCase
import com.test.luxcarservice.domain.use_case.GetUserIdFromSharedPrefsUseCase
import com.test.luxcarservice.domain.use_case.GetUsersFromDbUseCase

class OrdersViewModel(
    private val getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    private val getShopCartsFromDbUseCase: GetShopCartsFromDbUseCase,
    private val getShopCartsByUserIdFromDbUseCase: GetShopCartsByUserIdFromDbUseCase,
    private val getRolesFromDbUseCase: GetRolesFromDbUseCase,
    private val getProductsFromDbUseCase: GetProductsFromDbUseCase,
    private val getUsersFromDbUseCase: GetUsersFromDbUseCase,
    private val getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
) : ViewModel() {

    fun getUserId(): Long {
        return getUserIdFromSharedPrefsUseCase.execute()
    }

    fun getOrders(): List<ShopCart> {
        return getShopCartsFromDbUseCase.execute()
    }

    fun getUserOrders(userId: Long): List<ShopCart> {
        return getShopCartsByUserIdFromDbUseCase.execute(userId = userId)
    }

    fun getRoles(): List<Role> {
        return getRolesFromDbUseCase.execute()
    }

    fun getProducts(): List<Product> {
        return getProductsFromDbUseCase.execute()
    }

    fun getUsers(): List<User> {
        return getUsersFromDbUseCase.execute()
    }

    fun getUser(userId: Long): User {
        return getUserFromDbByIdUseCase.execute(userId = userId)
    }
}