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


    @Query("SELECT * FROM appointments")
    fun getAllAppointmentEntity(): List<AppointmentEntity>

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

    @Query("SELECT * FROM products WHERE id = :productId")
    fun getProductEntity(productId: Long): ProductEntity

    @Query("SELECT * FROM products")
    fun getAllProductEntity(): List<ProductEntity>

    //PRODUCT//

    //ROLE//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertRole(roleEntity: RoleEntity)

    //ROLE//

    //SERVICE//

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertServiceEntity(serviceEntity: ServiceEntity)

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

    @Query("SELECT * FROM shop_carts")
    fun getAllShopCartEntity(): List<ShopCartEntity>

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