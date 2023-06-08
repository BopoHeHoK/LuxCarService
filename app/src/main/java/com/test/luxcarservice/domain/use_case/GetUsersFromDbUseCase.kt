package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.User

class GetUsersFromDbUseCase(private val userRepository: UserRepository) {

    fun execute(): List<User> {
        return userRepository.getUsersFromDb()
    }
}