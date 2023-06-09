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
    suspend fun upsertAppointmentEntity(appointmentEntity: AppointmentEntity)

    @Query("SELECT * FROM appointments WHERE id = :appointmentId")
    fun getAppointmentEntity(appointmentId: Long): AppointmentEntity

    @Query("SELECT * FROM appointments ORDER BY id DESC LIMIT 1")
    fun getLastAppointmentEntity(): AppointmentEntity

    @Query("SELECT * FROM appointments")
    fun getAllAppointmentEntity(): List<AppointmentEntity>

    @Query("SELECT * FROM appointments WHERE user_id = :userId")
    fun getAppointmentByUserIdEntity(userId: Long): List<AppointmentEntity>

    //APPOINTMENT//

    //NOTIFICATION//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertNotificationEntity(notificationEntity: NotificationEntity)

    @Query("SELECT * FROM notifications WHERE id = :notificationId")
    fun getNotificationEntity(notificationId: Long): NotificationEntity

    @Query("SELECT * FROM notifications")
    fun getAllNotificationEntity(): List<NotificationEntity>

    //NOTIFICATION//

    //PRODUCT//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertProductEntity(productEntity: ProductEntity)

    @Query("DELETE FROM products WHERE id = :productId")
    suspend fun deleteProductById(productId: Long)

    @Query("DELETE FROM shop_carts WHERE product_id = :productId")
    suspend fun deleteShopCartByProductId(productId: Long)

    @Query("SELECT * FROM products WHERE id = :productId")
    fun getProductEntity(productId: Long): ProductEntity

    @Query("SELECT * FROM products")
    fun getAllProductEntity(): List<ProductEntity>

    //PRODUCT//

    //ROLE//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertRole(roleEntity: RoleEntity)

    @Query("SELECT * FROM roles")
    fun getAllRoleEntity(): List<RoleEntity>

    //ROLE//

    //SERVICE//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertServiceEntity(serviceEntity: ServiceEntity)

    @Query("DELETE FROM services WHERE id = :serviceId")
    suspend fun deleteServiceById(serviceId: Long)

    @Query("DELETE FROM appointments WHERE service_id = :serviceId")
    suspend fun deleteAppointmentByServiceId(serviceId: Long)

    @Query("SELECT * FROM services WHERE id = :serviceId")
    fun getServiceEntity(serviceId: Long): ServiceEntity

    @Query("SELECT * FROM services")
    fun getAllServiceEntity(): List<ServiceEntity>

    //SERVICE//

    //SHOP_CART//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertShopCartEntity(shopCartEntity: ShopCartEntity)

    @Query("SELECT * FROM shop_carts WHERE id = :shopCartId")
    fun getShopCartEntity(shopCartId: Long): ShopCartEntity

    @Query("SELECT * FROM shop_carts ORDER BY id DESC LIMIT 1")
    fun getLastShopCartEntity(): ShopCartEntity

    @Query("SELECT * FROM shop_carts")
    fun getAllShopCartEntity(): List<ShopCartEntity>

    @Query("SELECT * FROM shop_carts WHERE user_id = :userId")
    fun getShopCartByUserIdEntity(userId: Long): List<ShopCartEntity>

    //SHOP_CART//

    //USER//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertUserEntity(userEntity: UserEntity)

    @Query("SELECT * FROM users WHERE id = :userId")
    fun getUserEntity(userId: Long): UserEntity

    @Query("SELECT * FROM users ORDER BY id DESC LIMIT 1")
    fun getLastUserEntity(): UserEntity

    @Query("SELECT * FROM users WHERE email = :email")
    fun getUserEntity(email: String): UserEntity

    @Query("SELECT * FROM users")
    fun getAllUserEntity(): List<UserEntity>

    @Query("SELECT * FROM users WHERE email = :email")
    fun isEmailExists(email: String): UserEntity?

    @Query("SELECT * FROM users WHERE email = :email AND password = :password")
    fun isEmailAndPasswordCorrect(email: String, password: String): UserEntity?

    //USER//
}