package com.test.luxcarservice.domain.data.repository

import com.test.luxcarservice.domain.model.Appointment
import com.test.luxcarservice.domain.model.Notification
import com.test.luxcarservice.domain.model.Product
import com.test.luxcarservice.domain.model.Role
import com.test.luxcarservice.domain.model.Service
import com.test.luxcarservice.domain.model.ShopCart
import com.test.luxcarservice.domain.model.User

interface UserRepository {

    fun setUserIdSharedPreferences(userId: Long)

    fun getUserIdSharedPreferences(): Long

    fun checkUserEmail(email: String): Boolean

    fun checkUserEmailAndPassword(email: String, password: String): Boolean

    fun getLastUserFromDb(): User

    fun getUserFromDb(userId: Long): User

    fun getUserFromDb(email: String): User

    fun getUsersFromDb(): List<User>

    fun getAppointmentsFromDb(): List<Appointment>

    fun getNotificationsFromDb(): List<Notification>

    fun getShopCartsFromDb(): List<ShopCart>

    fun getProductsFromDb(): List<Product>

    fun getServicesFromDb(): List<Service>

    suspend fun saveRolesToDb(role: Role)

    suspend fun saveUserToDb(user: User)

    suspend fun saveAppointment(appointment: Appointment)

    suspend fun saveNotification(notification: Notification)

    suspend fun saveShopCart(shopCart: ShopCart)

    suspend fun saveProduct(product: Product)

    suspend fun saveService(service: Service)
}