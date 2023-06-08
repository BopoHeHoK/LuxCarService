package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.User

class SaveUserToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(user: User) {
        return userRepository.saveUserToDb(user = user)
    }
}