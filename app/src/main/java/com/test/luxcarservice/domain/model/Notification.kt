package com.test.luxcarservice.domain.model

data class Notification(
    val id: Long,
    val user_id: Long,
    val notification: String?,
)