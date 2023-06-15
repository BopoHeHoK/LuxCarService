package com.test.luxcarservice.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.test.luxcarservice.data.storage.modelDb.AppointmentEntity
import com.test.luxcarservice.data.storage.modelDb.NotificationEntity
import com.test.luxcarservice.data.storage.modelDb.ProductEntity
import com.test.luxcarservice.data.storage.modelDb.RoleEntity
import com.test.luxcarservice.data.storage.modelDb.ServiceEntity
import com.test.luxcarservice.data.storage.modelDb.ShopCartEntity
import com.test.luxcarservice.data.storage.modelDb.UserEntity

@Dao
interface LuxCarServiceDao {

    //APPOINTMENT//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertAppointment(appointmentEntity: AppointmentEntity)

    @Query("DELETE FROM appointments WHERE service_id = :serviceId")
    suspend fun deleteAppointmentsByServiceId(serviceId: Long)

    @Query("SELECT * FROM appointments WHERE id = :appointmentId")
    fun getAppointment(appointmentId: Long): AppointmentEntity

    @Query("SELECT * FROM appointments ORDER BY id DESC LIMIT 1")
    fun getLastAppointment(): AppointmentEntity

    @Query("SELECT * FROM appointments")
    fun getAllAppointments(): List<AppointmentEntity>

    @Query("SELECT * FROM appointments WHERE user_id = :userId")
    fun getAppointmentsByUserId(userId: Long): List<AppointmentEntity>

    //APPOINTMENT//

    //NOTIFICATION//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertNotification(notificationEntity: NotificationEntity)

    @Query("SELECT * FROM notifications ORDER BY id DESC LIMIT 1")
    fun getLastNotification(): NotificationEntity

    @Query("SELECT * FROM notifications WHERE id = :notificationId")
    fun getNotification(notificationId: Long): NotificationEntity

    @Query("SELECT * FROM notifications")
    fun getAllNotifications(): List<NotificationEntity>

    @Query("SELECT * FROM notifications WHERE user_id = :userId")
    fun getNotificationsByUserId(userId: Long): List<NotificationEntity>

    //NOTIFICATION//

    //PRODUCT//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertProduct(productEntity: ProductEntity)

    @Query("SELECT * FROM products ORDER BY id DESC LIMIT 1")
    fun getLastProduct(): ProductEntity

    @Query("DELETE FROM products WHERE id = :productId")
    suspend fun deleteProductById(productId: Long)

    @Query("SELECT * FROM products WHERE id = :productId")
    fun getProduct(productId: Long): ProductEntity

    @Query("SELECT * FROM products")
    fun getAllProducts(): List<ProductEntity>

    //PRODUCT//

    //ROLE//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertRole(roleEntity: RoleEntity)

    @Query("SELECT * FROM roles")
    fun getAllRoles(): List<RoleEntity>

    //ROLE//

    //SERVICE//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertService(serviceEntity: ServiceEntity)

    @Query("SELECT * FROM services ORDER BY id DESC LIMIT 1")
    fun getLastService(): ServiceEntity

    @Query("DELETE FROM services WHERE id = :serviceId")
    suspend fun deleteServiceById(serviceId: Long)

    @Query("SELECT * FROM services WHERE id = :serviceId")
    fun getService(serviceId: Long): ServiceEntity

    @Query("SELECT * FROM services")
    fun getAllServices(): List<ServiceEntity>

    //SERVICE//

    //SHOP_CART//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertShopCart(shopCartEntity: ShopCartEntity)

    @Query("DELETE FROM shop_carts WHERE product_id = :productId")
    suspend fun deleteShopCartsByProductId(productId: Long)

    @Query("SELECT * FROM shop_carts WHERE id = :shopCartId")
    fun getShopCart(shopCartId: Long): ShopCartEntity

    @Query("SELECT * FROM shop_carts ORDER BY id DESC LIMIT 1")
    fun getLastShopCart(): ShopCartEntity

    @Query("SELECT * FROM shop_carts")
    fun getAllShopCarts(): List<ShopCartEntity>

    @Query("SELECT * FROM shop_carts WHERE user_id = :userId")
    fun getShopCartsByUserIdEntity(userId: Long): List<ShopCartEntity>

    //SHOP_CART//

    //USER//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertUser(userEntity: UserEntity)

    @Query("SELECT * FROM users WHERE id = :userId")
    fun getUser(userId: Long): UserEntity

    @Query("SELECT * FROM users ORDER BY id DESC LIMIT 1")
    fun getLastUser(): UserEntity

    @Query("SELECT * FROM users WHERE email = :email")
    fun getUser(email: String): UserEntity

    @Query("SELECT * FROM users")
    fun getAllUsers(): List<UserEntity>

    @Query("SELECT * FROM users WHERE email = :email")
    fun isEmailExist(email: String): UserEntity?

    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    fun isEmailAndPasswordCorrect(email: String, password: String): UserEntity?

    //USER//
}