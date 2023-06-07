package com.test.luxcarservice.domain.model

data class User(
    val id: Long,
    val email: String?,
    val phone_number: String?,
    val first_name: String?,
    val last_name: String?,
    val role_id: Long,
)