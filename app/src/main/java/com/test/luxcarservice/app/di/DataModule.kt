package com.test.luxcarservice.app.di

import android.content.Context
import com.test.luxcarservice.data.db.LuxCarServiceDatabase
import com.test.luxcarservice.data.repository.SharedPreferences
import com.test.luxcarservice.data.repository.UserRepositoryImpl
import com.test.luxcarservice.data.storage.converters.ConverterEM
import com.test.luxcarservice.data.storage.converters.ConverterEMImpl
import com.test.luxcarservice.data.storage.converters.ConverterME
import com.test.luxcarservice.data.storage.converters.ConverterMEImpl
import com.test.luxcarservice.domain.data.repository.UserRepository
import com.test.luxcarservice.domain.data.repository.UserStorage
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    fun provideSharedPreferences(context: Context): UserStorage {
        return SharedPreferences(context = context)
    }

    @Provides
    fun provideLuxCarServiceDatabase(context: Context): LuxCarServiceDatabase {
        return LuxCarServiceDatabase.getInstance(context = context)
    }

    @Provides
    fun provideConverterEM(): ConverterEM {
        return ConverterEMImpl()
    }

    @Provides
    fun provideConverterME(): ConverterME {
        return ConverterMEImpl()
    }

    @Provides
    fun provideUserRepository(
        userStorage: UserStorage,
        luxCarServiceDatabase: LuxCarServiceDatabase,
        converterEM: ConverterEM,
        converterME: ConverterME,
    ): UserRepository {
        return UserRepositoryImpl(
            userStorage = userStorage,
            luxCarServiceDatabase = luxCarServiceDatabase,
            converterEM = converterEM,
            converterME = converterME,
        )
    }
}