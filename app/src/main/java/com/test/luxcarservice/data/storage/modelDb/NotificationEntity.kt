package com.test.luxcarservice.data.storage.modelDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "notifications",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"]
        ),
        ForeignKey(
            entity = AppointmentEntity::class,
            parentColumns = ["id"],
            childColumns = ["appointment_id"]
        ),
        ForeignKey(
            entity = ShopCartEntity::class,
            parentColumns = ["id"],
            childColumns = ["shop_card_id"]
        )
    ]
)
data class NotificationEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "user_id")
    val user_id: Long,
    @ColumnInfo(name = "appointment_id")
    val appointment_id: Long?,
    @ColumnInfo(name = "shop_card_id")
    val shopCard_id: Long?,
)