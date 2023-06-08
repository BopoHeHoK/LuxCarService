package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository

class GetUserIdFromSharedPrefsUseCase(private val userRepository: UserRepository) {

    fun execute(): Long {
        return userRepository.getUserIdSharedPreferences()
    }
}