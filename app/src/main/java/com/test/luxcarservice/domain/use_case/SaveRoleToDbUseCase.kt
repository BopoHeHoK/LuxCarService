package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.Role

class SaveRoleToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(role: Role) {
        return userRepository.saveRolesToDb(role = role)
    }
}