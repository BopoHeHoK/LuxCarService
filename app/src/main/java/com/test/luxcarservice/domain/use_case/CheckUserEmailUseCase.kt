package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository

class CheckUserEmailUseCase(private val userRepository: UserRepository) {

    fun execute(email: String): Boolean {
        return userRepository.checkUserEmail(email = email)
    }
}