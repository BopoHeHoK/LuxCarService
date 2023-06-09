package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.Role

class GetRolesFromDbUseCase(private val userRepository: UserRepository) {

    fun execute(): List<Role> {
        return userRepository.getRolesFromDb()
    }
}