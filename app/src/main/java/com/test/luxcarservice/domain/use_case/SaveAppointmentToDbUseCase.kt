package com.test.luxcarservice.domain.use_case

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.model.Appointment

class SaveAppointmentToDbUseCase(private val userRepository: UserRepository) {

    suspend fun execute(appointment: Appointment) {
        return userRepository.saveAppointment(appointment = appointment)
    }
}