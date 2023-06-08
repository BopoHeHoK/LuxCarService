package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.User

class GetUserFromDbByEmailUseCase(private val userRepository: UserRepository) {

    fun execute(email: String): User {
        return userRepository.getUserFromDb(email = email)
    }
}