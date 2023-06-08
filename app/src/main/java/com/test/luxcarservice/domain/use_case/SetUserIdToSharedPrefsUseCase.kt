package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository

class SetUserIdToSharedPrefsUseCase(private val userRepository: UserRepository) {

    fun execute(userId: Long) {
        return userRepository.setUserIdSharedPreferences(userId = userId)
    }
}