package com.test.luxcarservice.data.storage.converters

import com.test.luxcarservice.data.storage.modelDb.AppointmentEntity
import com.test.luxcarservice.data.storage.modelDb.NotificationEntity
import com.test.luxcarservice.data.storage.modelDb.ProductEntity
import com.test.luxcarservice.data.storage.modelDb.RoleEntity
import com.test.luxcarservice.data.storage.modelDb.ServiceEntity
import com.test.luxcarservice.data.storage.modelDb.ShopCartEntity
import com.test.luxcarservice.data.storage.modelDb.UserEntity
import com.test.luxcarservice.domain.model.Appointment
import com.test.luxcarservice.domain.model.Notification
import com.test.luxcarservice.domain.model.Product
import com.test.luxcarservice.domain.model.Role
import com.test.luxcarservice.domain.model.Service
import com.test.luxcarservice.domain.model.ShopCart
import com.test.luxcarservice.domain.model.User

interface ConverterEM {
    fun toAppointment(appointmentEntity: AppointmentEntity): Appointment
    fun toNotification(notificationEntity: NotificationEntity): Notification
    fun toProduct(productEntity: ProductEntity): Product
    fun toRole(roleEntity: RoleEntity): Role
    fun toService(serviceEntity: ServiceEntity): Service
    fun toShopCart(shopCartEntity: ShopCartEntity): ShopCart
    fun toUser(userEntity: UserEntity): User
}

class ConverterEMImpl : ConverterEM {
    override fun toAppointment(appointmentEntity: AppointmentEntity): Appointment {
        return Appointment(
            id = appointmentEntity.id,
            user_id = appointmentEntity.user_id,
            service_id = appointmentEntity.service_id,
            date = appointmentEntity.date,
            time = appointmentEntity.time,
        )
    }

    override fun toNotification(notificationEntity: NotificationEntity): Notification {
        return Notification(
            id = notificationEntity.id,
            user_id = notificationEntity.user_id,
            notification = notificationEntity.notification,
        )
    }

    override fun toProduct(productEntity: ProductEntity): Product {
        return Product(
            id = productEntity.id,
            name = productEntity.name,
            description = productEntity.description,
            price = productEntity.price,
        )
    }

    override fun toRole(roleEntity: RoleEntity): Role {
        return Role(
            id = roleEntity.id,
            role = roleEntity.role,
        )
    }

    override fun toService(serviceEntity: ServiceEntity): Service {
        return Service(
            id = serviceEntity.id,
            name = serviceEntity.name,
            description = serviceEntity.description,
            price = serviceEntity.price,
        )
    }

    override fun toShopCart(shopCartEntity: ShopCartEntity): ShopCart {
        return ShopCart(
            id = shopCartEntity.id,
            user_id = shopCartEntity.user_id,
            product_id = shopCartEntity.product_id,
            count = shopCartEntity.count,
        )
    }

    override fun toUser(userEntity: UserEntity): User {
        return User(
            id = userEntity.id,
            email = userEntity.email,
            phone_number = userEntity.phone_number,
            first_name = userEntity.first_name,
            last_name = userEntity.last_name,
            role_id = userEntity.role_id,
        )
    }
}