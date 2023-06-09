package com.test.luxcarservice.domain.model

data class ShopCart(
    val id: Long,
    val user_id: Long,
    val product_id: Long,
    val price: Float?,
    val count: Long?,
)