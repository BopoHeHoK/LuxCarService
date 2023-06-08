package com.test.luxcarservice.app.di

import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.use_case.CheckUserEmailAndPasswordUseCase
import com.test.luxcarservice.domain.use_case.CheckUserEmailUseCase
import com.test.luxcarservice.domain.use_case.GetAppointmentsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetLastUserFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetNotificationsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetProductsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetServicesFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetShopCartsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetUserFromDbByEmailUseCase
import com.test.luxcarservice.domain.use_case.GetUserFromDbByIdUseCase
import com.test.luxcarservice.domain.use_case.GetUserIdFromSharedPrefsUseCase
import com.test.luxcarservice.domain.use_case.GetUsersFromDbUseCase
import com.test.luxcarservice.domain.use_case.SaveAppointmentToDbUseCase
import com.test.luxcarservice.domain.use_case.SaveNotificationsToDbUseCase
import com.test.luxcarservice.domain.use_case.SaveProductToDbUseCase
import com.test.luxcarservice.domain.use_case.SaveRoleToDbUseCase
import com.test.luxcarservice.domain.use_case.SaveServiceToDbUseCase
import com.test.luxcarservice.domain.use_case.SaveShopCartToDbUseCase
import com.test.luxcarservice.domain.use_case.SaveUserToDbUseCase
import com.test.luxcarservice.domain.use_case.SetUserIdToSharedPrefsUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideCheckUserEmailAndPasswordUseCase(userRepository: UserRepository): CheckUserEmailAndPasswordUseCase {
        return CheckUserEmailAndPasswordUseCase(userRepository = userRepository)
    }
    @Provides
    fun provideCheckUserEmailUseCase(userRepository: UserRepository): CheckUserEmailUseCase {
        return CheckUserEmailUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetAppointmentsFromDbUseCase(userRepository: UserRepository): GetAppointmentsFromDbUseCase {
        return GetAppointmentsFromDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetLastUserFromDbUseCase(userRepository: UserRepository): GetLastUserFromDbUseCase {
        return GetLastUserFromDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetNotificationsFromDbUseCase(userRepository: UserRepository): GetNotificationsFromDbUseCase {
        return GetNotificationsFromDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetProductsFromDbUseCase(userRepository: UserRepository): GetProductsFromDbUseCase {
        return GetProductsFromDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetServicesFromDbUseCase(userRepository: UserRepository): GetServicesFromDbUseCase {
        return GetServicesFromDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetShopCartsFromDbUseCase(userRepository: UserRepository): GetShopCartsFromDbUseCase {
        return GetShopCartsFromDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetUserFromDbByEmailUseCase(userRepository: UserRepository): GetUserFromDbByEmailUseCase {
        return GetUserFromDbByEmailUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetUserFromDbByIdUseCase(userRepository: UserRepository): GetUserFromDbByIdUseCase {
        return GetUserFromDbByIdUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetUserIdFromSharedPrefsUseCase(userRepository: UserRepository): GetUserIdFromSharedPrefsUseCase {
        return GetUserIdFromSharedPrefsUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideGetUsersFromDbUseCase(userRepository: UserRepository): GetUsersFromDbUseCase {
        return GetUsersFromDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveAppointmentToDbUseCase(userRepository: UserRepository): SaveAppointmentToDbUseCase {
        return SaveAppointmentToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveNotificationsToDbUseCase(userRepository: UserRepository): SaveNotificationsToDbUseCase {
        return SaveNotificationsToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveProductToDbUseCase(userRepository: UserRepository): SaveProductToDbUseCase {
        return SaveProductToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveRoleToDbUseCase(userRepository: UserRepository): SaveRoleToDbUseCase {
        return SaveRoleToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveServiceToDbUseCase(userRepository: UserRepository): SaveServiceToDbUseCase {
        return SaveServiceToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveShopCartToDbUseCase(userRepository: UserRepository): SaveShopCartToDbUseCase {
        return SaveShopCartToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSaveUserToDbUseCase(userRepository: UserRepository): SaveUserToDbUseCase {
        return SaveUserToDbUseCase(userRepository = userRepository)
    }

    @Provides
    fun provideSetUserIdToSharedPrefsUseCase(userRepository: UserRepository): SetUserIdToSharedPrefsUseCase {
        return SetUserIdToSharedPrefsUseCase(userRepository = userRepository)
    }
}