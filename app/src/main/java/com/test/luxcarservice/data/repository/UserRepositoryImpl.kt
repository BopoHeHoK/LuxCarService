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
        if (luxCarServiceDatabase.luxCarServiceDao().isEmailExists(email = email) != null) {
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

    override fun getLastUserFromDb(): User {
        return converterEM.toUser(luxCarServiceDatabase.luxCarServiceDao().getLastUserEntity())
    }

    override fun getUserFromDb(userId: Long): User {
        return converterEM.toUser(
            luxCarServiceDatabase.luxCarServiceDao().getUserEntity(userId = userId)
        )
    }

    override fun getUserFromDb(email: String): User {
        return converterEM.toUser(
            luxCarServiceDatabase.luxCarServiceDao().getUserEntity(email = email)
        )
    }

    override fun getUsersFromDb(): List<User> {
        return converterEM.toUserList(luxCarServiceDatabase.luxCarServiceDao().getAllUserEntity())
    }

    override fun getAppointmentsFromDb(): List<Appointment> {
        return converterEM.toAppointmentList(
            luxCarServiceDatabase.luxCarServiceDao().getAllAppointmentEntity()
        )
    }

    override fun getNotificationsFromDb(): List<Notification> {
        return converterEM.toNotificationList(
            luxCarServiceDatabase.luxCarServiceDao().getAllNotificationEntity()
        )
    }

    override fun getShopCartsFromDb(): List<ShopCart> {
        return converterEM.toShopCartList(
            luxCarServiceDatabase.luxCarServiceDao().getAllShopCartEntity()
        )
    }

    override fun getProductsFromDb(): List<Product> {
        return converterEM.toProductList(
            luxCarServiceDatabase.luxCarServiceDao().getAllProductEntity()
        )
    }

    override fun getServicesFromDb(): List<Service> {
        return converterEM.toServiceList(
            luxCarServiceDatabase.luxCarServiceDao().getAllServiceEntity()
        )
    }

    override suspend fun saveRolesToDb(role: Role) {
        luxCarServiceDatabase.luxCarServiceDao().upsertRole(converterME.toRoleEntity(role = role))
    }

    override suspend fun saveUserToDb(user: User) {
        luxCarServiceDatabase.luxCarServiceDao()
            .upsertUserEntity(converterME.toUserEntity(user = user))
    }

    override suspend fun saveAppointment(appointment: Appointment) {
        luxCarServiceDatabase.luxCarServiceDao()
            .upsertAppointmentEntity(converterME.toAppointmentEntity(appointment = appointment))
    }

    override suspend fun saveNotification(notification: Notification) {
        luxCarServiceDatabase.luxCarServiceDao()
            .upsertNotificationEntity(converterME.toNotificationEntity(notification = notification))
    }

    override suspend fun saveShopCart(shopCart: ShopCart) {
        luxCarServiceDatabase.luxCarServiceDao()
            .upsertShopCartEntity(converterME.toShopCartEntity(shopCart = shopCart))
    }

    override suspend fun saveProduct(product: Product) {
        luxCarServiceDatabase.luxCarServiceDao()
            .upsertProductEntity(converterME.toProductEntity(product = product))
    }

    override suspend fun saveService(service: Service) {
        luxCarServiceDatabase.luxCarServiceDao()
            .upsertServiceEntity(converterME.toServiceEntity(service = service))
    }
}