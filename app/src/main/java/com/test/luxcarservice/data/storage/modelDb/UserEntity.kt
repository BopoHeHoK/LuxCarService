package com.test.luxcarservice.data.storage.modelDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "users",
    foreignKeys = [
        ForeignKey(
            entity = RoleEntity::class,
            parentColumns = ["id"],
            childColumns = ["role_id"]
        )
    ]
)
data class UserEntity(
    @PrimaryKey
    val id: Long,
    val email: String?,
    val phone_number: String?,
    val first_name: String?,
    val last_name: String?,
    @ColumnInfo(name = "role_id")
    val role_id: Long,
)
