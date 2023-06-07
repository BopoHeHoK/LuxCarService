package com.test.luxcarservice.data.storage.modelDb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "services")
data class ServiceEntity(
    @PrimaryKey
    val id: Long,
    val name: String?,
    val description: String?,
    val price: Float?,
)