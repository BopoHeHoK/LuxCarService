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

interface ConverterME {
    fun toAppointmentEntity(appointment: Appointment): AppointmentEntity
    fun toNotificationEntity(notification: Notification): NotificationEntity
    fun toProductEntity(product: Product): ProductEntity
    fun toRoleEntity(role: Role): RoleEntity
    fun toServiceEntity(service: Service): ServiceEntity
    fun toShopCartEntity(shopCart: ShopCart): ShopCartEntity
    fun toUserEntity(user: User): UserEntity
}

class ConverterMEImpl : ConverterME {
    override fun toAppointmentEntity(appointment: Appointment): AppointmentEntity {
        return AppointmentEntity(
            id = appointment.id,
            user_id = appointment.user_id,
            service_id = appointment.service_id,
            date = appointment.date,
            time = appointment.time,
        )
    }

    override fun toNotificationEntity(notification: Notification): NotificationEntity {
        return NotificationEntity(
            id = notification.id,
            user_id = notification.user_id,
            notification = notification.notification,
        )
    }

    override fun toProductEntity(product: Product): ProductEntity {
        return ProductEntity(
            id = product.id,
            name = product.name,
            description = product.description,
            price = product.price,
        )
    }

    override fun toRoleEntity(role: Role): RoleEntity {
        return RoleEntity(
            id = role.id,
            role = role.role,
        )
    }

    override fun toServiceEntity(service: Service): ServiceEntity {
        return ServiceEntity(
            id = service.id,
            name = service.name,
            description = service.description,
            price = service.price,
        )
    }

    override fun toShopCartEntity(shopCart: ShopCart): ShopCartEntity {
        return ShopCartEntity(
            id = shopCart.id,
            user_id = shopCart.user_id,
            product_id = shopCart.product_id,
            count = shopCart.count,
        )
    }

    override fun toUserEntity(user: User): UserEntity {
        return UserEntity(
            id = user.id,
            email = user.email,
            password = user.password,
            phone_number = user.phone_number,
            first_name = user.first_name,
            last_name = user.last_name,
            role_id = user.role_id,
        )
    }
}