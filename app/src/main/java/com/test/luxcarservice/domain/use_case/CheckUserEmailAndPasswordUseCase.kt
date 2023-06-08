package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository

class CheckUserEmailAndPasswordUseCase(private val userRepository: UserRepository) {

    fun execute(email: String, password: String): Boolean {
        return userRepository.checkUserEmailAndPassword(email = email, password = password)
    }
}