package com.test.luxcarservice.domain.data.repository

interface UserStorage {

    fun setUserId(userId: Long)

    fun getUserId(): Long

}