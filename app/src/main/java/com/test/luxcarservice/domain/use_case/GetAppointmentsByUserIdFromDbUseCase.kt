package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.Appointment

class GetAppointmentsByUserIdFromDbUseCase(private val userRepository: UserRepository) {

    fun execute(userId: Long): List<Appointment> {
        return userRepository.getAppointmentsByUserIdFromDb(userId = userId)
    }
}