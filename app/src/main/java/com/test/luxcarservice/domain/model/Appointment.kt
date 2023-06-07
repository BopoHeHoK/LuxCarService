package com.test.luxcarservice.domain.model

data class Appointment(
    val id: Long,
    val user_id: Long,
    val service_id: Long,
    val date: String?,
    val time: String?,
)