package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.User

class GetUserFromDbByIdUseCase(private val userRepository: UserRepository) {

    fun execute(userId: Long): User {
        return userRepository.getUserFromDb(userId = userId)
    }
}