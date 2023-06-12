package com.test.luxcarservice.data.repository

import com.test.luxcarservice.data.db.LuxCarServiceDatabase
import com.test.luxcarservice.data.storage.converters.ConverterEM
import com.test.luxcarservice.data.storage.converters.ConverterME
import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.data.repository.UserStorage
import com.test.luxcarservice.domain.model.Appointment
import com.test.luxcarservice.domain.model.Notification
import com.test.luxcarservice.domain.model.Product
import com.test.luxcarservice.domain.model.Role
import com.test.luxcarservice.domain.model.Service
import com.test.luxcarservice.domain.model.ShopCart
import com.test.luxcarservice.domain.model.User

class UserRepositoryImpl(
    private val userStorage: UserStorage,
    private val luxCarServiceDatabase: LuxCarServiceDatabase,
    private val converterEM: ConverterEM,
    private val converterME: ConverterME,
) : UserRepository {
    override fun setUserIdSharedPreferences(userId: Long) {
        userStorage.setUserId(userId = userId)
    }

    override fun getUserIdSharedPreferences(): Long {
        return userStorage.getUserId()
    }

    override fun checkUserEmail(email: String): Boolean {
        if (luxCarServiceDatabase.luxCarServiceDao().isEmailExist(email = email) != null) {
            return true
        }
        return false
    }

    override fun checkUserEmailAndPassword(email: String, password: String): Boolean {
        if (luxCarServiceDatabase.luxCarServiceDao()
                .isEmailAndPasswordCorrect(email = email, password = password) != null
        ) {
            return true
        }
        return false
    }

    override suspend fun deleteProductByIdFromDbUseCase(productId: Long) {
        luxCarServiceDatabase.luxCarServiceDao().deleteShopCartsByProductId(productId = productId)
        luxCarServiceDatabase.luxCarServiceDao().deleteProductById(productId = productId)
    }

    override suspend fun deleteServiceByIdFromDbUseCase(serviceId: Long) {
        luxCarServiceDatabase.luxCarServiceDao()
            .deleteAppointmentsByServiceId(serviceId = serviceId)
        luxCarServiceDatabase.luxCarServiceDao().deleteServiceById(serviceId = serviceId)
    }

    override fun getLastAppointmentFromDb(): Appointment {
        return converterEM.toAppointment(
            luxCarServiceDatabase.luxCarServiceDao().getLastAppointment()
        )
    }

    override fun getLastNotificationFromDb(): Notification {
        return converterEM.toNotification(
            luxCarServiceDatabase.luxCarServiceDao().getLastNotification()
        )
    }

    override fun getLastShopCartFromDb(): ShopCart {
        return converterEM.toShopCart(
            luxCarServiceDatabase.luxCarServiceDao().getLastShopCart()
        )
    }

    override fun getLastUserFromDb(): User {
        return converterEM.toUser(luxCarServiceDatabase.luxCarServiceDao().getLastUser())
    }

    override fun getUserFromDb(userId: Long): User {
        return converterEM.toUser(
            luxCarServiceDatabase.luxCarServiceDao().getUser(userId = userId)
        )
    }

    override fun getUserFromDb(email: String): User {
        return converterEM.toUser(
            luxCarServiceDatabase.luxCarServiceDao().getUser(email = email)
        )
    }

    override fun getUsersFromDb(): List<User> {
        return converterEM.toUserList(luxCarServiceDatabase.luxCarServiceDao().getAllUsers())
    }

    override fun getRolesFromDb(): List<Role> {
        return converterEM.toRoleList(luxCarServiceDatabase.luxCarServiceDao().getAllRoles())
    }

    override fun getAppointmentsFromDb(): List<Appointment> {
        return converterEM.toAppointmentList(
            luxCarServiceDatabase.luxCarServiceDao().getAllAppointments()
        )
    }

    override fun getAppointmentsByUserIdFromDb(userId: Long): List<Appointment> {
        return converterEM.toAppointmentList(
            luxCarServiceDatabase.luxCarServiceDao().getAppointmentsByUserId(userId = userId)
        )
    }

    override fun getNotificationsFromDb(): List<Notification> {
        return converterEM.toNotificationList(
            luxCarServiceDatabase.luxCarServiceDao().getAllNotifications()
        )
    }

    override fun getNotificationsByUserIdFromDb(userId: Long): List<Notification> {
        return converterEM.toNotificationList(
            luxCarServiceDatabase.luxCarServiceDao().getNotificationsByUserId(userId = userId)
        )
    }

    override fun getShopCartsFromDb(): List<ShopCart> {
        return converterEM.toShopCartList(
            luxCarServiceDatabase.luxCarServiceDao().getAllShopCarts()
        )
    }

    override fun getShopCartsByUserIdFromDb(userId: Long): List<ShopCart> {
        return converterEM.toShopCartList(
            luxCarServiceDatabase.luxCarServiceDao().getShopCartsByUserIdEntity(userId = userId)
        )
    }

    override fun getProductsFromDb(): List<Product> {
        return converterEM.toProductList(
            luxCarServiceDatabase.luxCarServiceDao().getAllProducts()
        )
    }

    override fun getServicesFromDb(): List<Service> {
        return converterEM.toServiceList(
            luxCarServiceDatabase.luxCarServiceDao().getAllServices()
        )
    }

    override suspend fun saveRolesToDb(role: Role) {
        luxCarServiceDatabase.luxCarServiceDao().upsertRole(converterME.toRoleEntity(role = role))
    }

    override suspend fun saveUserToDb(user: User) {
        luxCarServiceDatabase.luxCarServiceDao()
            .upsertUser(converterME.toUserEntity(user = user))
    }

    override suspend fun saveAppointment(appointment: Appointment) {
        luxCarServiceDatabase.luxCarServiceDao()
            .upsertAppointment(converterME.toAppointmentEntity(appointment = appointment))
    }

    override suspend fun saveNotification(notification: Notification) {
        luxCarServiceDatabase.luxCarServiceDao()
            .upsertNotification(converterME.toNotificationEntity(notification = notification))
    }

    override suspend fun saveShopCart(shopCart: ShopCart) {
        luxCarServiceDatabase.luxCarServiceDao()
            .upsertShopCart(converterME.toShopCartEntity(shopCart = shopCart))
    }

    override suspend fun saveProduct(product: Product) {
        luxCarServiceDatabase.luxCarServiceDao()
            .upsertProduct(converterME.toProductEntity(product = product))
    }

    override suspend fun saveService(service: Service) {
        luxCarServiceDatabase.luxCarServiceDao()
            .upsertService(converterME.toServiceEntity(service = service))
    }
}