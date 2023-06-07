package com.test.luxcarservice.data.storage.modelDb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "shop_carts",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"]
        ),
        ForeignKey(
            entity = ProductEntity::class,
            parentColumns = ["id"],
            childColumns = ["product_id"]
        )
    ]
)
data class ShopCartEntity(
    @PrimaryKey
    val id: Long,
    @ColumnInfo(name = "user_id")
    val user_id: Long,
    @ColumnInfo(name = "product_id")
    val product_id: Long,
    val count: Long?,
)
