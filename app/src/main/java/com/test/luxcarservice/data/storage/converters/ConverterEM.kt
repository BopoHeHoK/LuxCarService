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
    fun toAppointmentList(appointmentEntityList: List<AppointmentEntity>): List<Appointment>
    fun toNotification(notificationEntity: NotificationEntity): Notification
    fun toNotificationList(notificationEntityList: List<NotificationEntity>): List<Notification>
    fun toProduct(productEntity: ProductEntity): Product
    fun toProductList(productEntityList: List<ProductEntity>): List<Product>
    fun toRole(roleEntity: RoleEntity): Role

    fun toRoleList(roleEntityList: List<RoleEntity>): List<Role>
    fun toService(serviceEntity: ServiceEntity): Service
    fun toServiceList(serviceEntityList: List<ServiceEntity>): List<Service>
    fun toShopCart(shopCartEntity: ShopCartEntity): ShopCart
    fun toShopCartList(shopCartEntityList: List<ShopCartEntity>): List<ShopCart>
    fun toUser(userEntity: UserEntity): User
    fun toUserList(userEntityList: List<UserEntity>): List<User>
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

    override fun toAppointmentList(appointmentEntityList: List<AppointmentEntity>): List<Appointment> {
        val result = ArrayList<Appointment>()
        appointmentEntityList.forEach {
            val converted = Appointment(
                id = it.id,
                user_id = it.user_id,
                service_id = it.service_id,
                date = it.date,
                time = it.time,
            )
            result.add(converted)
        }
        return result
    }

    override fun toNotification(notificationEntity: NotificationEntity): Notification {
        return Notification(
            id = notificationEntity.id,
            user_id = notificationEntity.user_id,
            notification = notificationEntity.notification,
        )
    }

    override fun toNotificationList(notificationEntityList: List<NotificationEntity>): List<Notification> {
        val result = ArrayList<Notification>()
        notificationEntityList.forEach {
            val converted = Notification(
                id = it.id,
                user_id = it.user_id,
                notification = it.notification,
            )
            result.add(converted)
        }
        return result
    }

    override fun toProduct(productEntity: ProductEntity): Product {
        return Product(
            id = productEntity.id,
            name = productEntity.name,
            description = productEntity.description,
            price = productEntity.price,
        )
    }

    override fun toProductList(productEntityList: List<ProductEntity>): List<Product> {
        val result = ArrayList<Product>()
        productEntityList.forEach {
            val converted = Product(
                id = it.id,
                name = it.name,
                description = it.description,
                price = it.price,
            )
            result.add(converted)
        }
        return result
    }

    override fun toRole(roleEntity: RoleEntity): Role {
        return Role(
            id = roleEntity.id,
            role = roleEntity.role,
        )
    }

    override fun toRoleList(roleEntityList: List<RoleEntity>): List<Role> {
        val result = ArrayList<Role>()
        roleEntityList.forEach {
            val converted = Role(
                id = it.id,
                role = it.role,
            )
            result.add(converted)
        }
        return result
    }

    override fun toService(serviceEntity: ServiceEntity): Service {
        return Service(
            id = serviceEntity.id,
            name = serviceEntity.name,
            description = serviceEntity.description,
            price = serviceEntity.price,
        )
    }

    override fun toServiceList(serviceEntityList: List<ServiceEntity>): List<Service> {
        val result = ArrayList<Service>()
        serviceEntityList.forEach {
            val converted = Service(
                id = it.id,
                name = it.name,
                description = it.description,
                price = it.price,
            )
            result.add(converted)
        }
        return result
    }

    override fun toShopCart(shopCartEntity: ShopCartEntity): ShopCart {
        return ShopCart(
            id = shopCartEntity.id,
            user_id = shopCartEntity.user_id,
            product_id = shopCartEntity.product_id,
            price = shopCartEntity.price,
            count = shopCartEntity.count,
        )
    }

    override fun toShopCartList(shopCartEntityList: List<ShopCartEntity>): List<ShopCart> {
        val result = ArrayList<ShopCart>()
        shopCartEntityList.forEach {
            val converted = ShopCart(
                id = it.id,
                user_id = it.user_id,
                product_id = it.product_id,
                price = it.price,
                count = it.count,
            )
            result.add(converted)
        }
        return result
    }

    override fun toUser(userEntity: UserEntity): User {
        return User(
            id = userEntity.id,
            email = userEntity.email,
            password = userEntity.password,
            phone_number = userEntity.phone_number,
            first_name = userEntity.first_name,
            last_name = userEntity.last_name,
            role_id = userEntity.role_id,
        )
    }

    override fun toUserList(userEntityList: List<UserEntity>): List<User> {
        val result = ArrayList<User>()
        userEntityList.forEach {
            val converted = User(
                id = it.id,
                email = it.email,
                password = it.password,
                phone_number = it.phone_number,
                first_name = it.first_name,
                last_name = it.last_name,
                role_id = it.role_id,
            )
            result.add(converted)
        }
        return result
    }
}