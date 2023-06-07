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
        )
    ]
)
data class NotificationEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "user_id")
    val user_id: Long,
    val notification: String?,
)