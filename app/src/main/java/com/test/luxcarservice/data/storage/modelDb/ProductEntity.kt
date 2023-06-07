package com.test.luxcarservice.data.storage.modelDb

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey
    val id: Long,
    val name: String?,
    val description: String?,
    val price: Float?,
)
