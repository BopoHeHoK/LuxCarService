package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.Appointment

class GetAppointmentsFromDbUseCase(private val userRepository: UserRepository) {

    fun execute(): List<Appointment> {
        return userRepository.getAppointmentsFromDb()
    }
}