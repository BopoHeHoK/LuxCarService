package com.test.luxcarservice.data.storage.modelDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "appointments",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"]
        ),
        ForeignKey(
            entity = ServiceEntity::class,
            parentColumns = ["id"],
            childColumns = ["service_id"]
        )
    ]
)
data class AppointmentEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "user_id")
    val user_id: Long,
    @ColumnInfo(name = "service_id")
    val service_id: Long,
    val date: String?,
    val time: String?,
)
