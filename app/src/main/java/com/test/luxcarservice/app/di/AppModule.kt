package com.test.luxcarservice.app.di

import android.content.Context
import com.test.luxcarservice.app.presentation.screen.appointments.AppointmentsViewModelFactory
import com.test.luxcarservice.app.presentation.screen.information.InformationViewModelFactory
import com.test.luxcarservice.app.presentation.screen.notifications.NotificationsViewModelFactory
import com.test.luxcarservice.app.presentation.screen.orders.OrdersViewModelFactory
import com.test.luxcarservice.app.presentation.screen.products.ProductsViewModelFactory
import com.test.luxcarservice.app.presentation.screen.profile.ProfileViewModelFactory
import com.test.luxcarservice.app.presentation.screen.profile_settings.ProfileSettingsViewModelFactory
import com.test.luxcarservice.app.presentation.screen.root.RootViewModelFactory
import com.test.luxcarservice.app.presentation.screen.services.ServicesViewModelFactory
import com.test.luxcarservice.app.presentation.screen.signin.SignInViewModelFactory
import com.test.luxcarservice.app.presentation.screen.signup.SignUpViewModelFactory
import com.test.luxcarservice.app.presentation.screen.splash.SplashViewModelFactory
import com.test.luxcarservice.domain.use_case.CheckUserEmailAndPasswordUseCase
import com.test.luxcarservice.domain.use_case.CheckUserEmailUseCase
import com.test.luxcarservice.domain.use_case.GetAppointmentsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetLastUserFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetNotificationsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetProductsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetServicesFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetShopCartsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetUserFromDbByEmailUseCase
import com.test.luxcarservice.domain.use_case.GetUserIdFromSharedPrefsUseCase
import com.test.luxcarservice.domain.use_case.GetUsersFromDbUseCase
import com.test.luxcarservice.domain.use_case.SaveRoleToDbUseCase
import com.test.luxcarservice.domain.use_case.SaveUserToDbUseCase
import com.test.luxcarservice.domain.use_case.SetUserIdToSharedPrefsUseCase
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
    fun provideContext(): Context {
        return context
    }

    @Provides
    fun provideAppointmentsViewModelFactory(
        getAppointmentsFromDbUseCase: GetAppointmentsFromDbUseCase,
    ): AppointmentsViewModelFactory {
        return AppointmentsViewModelFactory(
            getAppointmentsFromDbUseCase = getAppointmentsFromDbUseCase
        )
    }

    @Provides
    fun provideInformationViewModelFactory(

    ): InformationViewModelFactory {
        return InformationViewModelFactory(

        )
    }

    @Provides
    fun provideNotificationsViewModelFactory(
        getNotificationsFromDbUseCase: GetNotificationsFromDbUseCase,
    ): NotificationsViewModelFactory {
        return NotificationsViewModelFactory(
            getNotificationsFromDbUseCase = getNotificationsFromDbUseCase,
        )
    }

    @Provides
    fun provideOrdersViewModelFactory(
        getShopCartsFromDbUseCase: GetShopCartsFromDbUseCase,
    ): OrdersViewModelFactory {
        return OrdersViewModelFactory(
            getShopCartsFromDbUseCase = getShopCartsFromDbUseCase,
        )
    }

    @Provides
    fun provideProductsViewModelFactory(
        getProductsFromDbUseCase: GetProductsFromDbUseCase,
    ): ProductsViewModelFactory {
        return ProductsViewModelFactory(
            getProductsFromDbUseCase = getProductsFromDbUseCase,
        )
    }

    @Provides
    fun provideProfileViewModelFactory(
        setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,

        ): ProfileViewModelFactory {
        return ProfileViewModelFactory(
            setUserIdToSharedPrefsUseCase = setUserIdToSharedPrefsUseCase,
        )
    }

    @Provides
    fun provideProfileSettingsViewModelFactory(

    ): ProfileSettingsViewModelFactory {
        return ProfileSettingsViewModelFactory(

        )
    }

    @Provides
    fun provideRootViewModelFactory(
        setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,
    ): RootViewModelFactory {
        return RootViewModelFactory(
            setUserIdToSharedPrefsUseCase = setUserIdToSharedPrefsUseCase,
        )
    }

    @Provides
    fun provideServicesViewModelFactory(
        getServicesFromDbUseCase: GetServicesFromDbUseCase,
    ): ServicesViewModelFactory {
        return ServicesViewModelFactory(
            getServicesFromDbUseCase = getServicesFromDbUseCase,
        )
    }

    @Provides
    fun provideSignInViewModelFactory(
        checkUserEmailAndPasswordUseCase: CheckUserEmailAndPasswordUseCase,
        getUserFromDbByEmailUseCase: GetUserFromDbByEmailUseCase,
        setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,
    ): SignInViewModelFactory {
        return SignInViewModelFactory(
            checkUserEmailAndPasswordUseCase = checkUserEmailAndPasswordUseCase,
            getUserFromDbByEmailUseCase = getUserFromDbByEmailUseCase,
            setUserIdToSharedPrefsUseCase = setUserIdToSharedPrefsUseCase,
        )
    }

    @Provides
    fun provideSignUpViewModelFactory(
        getUsersFromDbUseCase: GetUsersFromDbUseCase,
        getLastUserFromDbUseCase: GetLastUserFromDbUseCase,
        checkUserEmailUseCase: CheckUserEmailUseCase,
        setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,
        saveUserToDbUseCase: SaveUserToDbUseCase,
    ): SignUpViewModelFactory {
        return SignUpViewModelFactory(
            getUsersFromDbUseCase = getUsersFromDbUseCase,
            getLastUserFromDbUseCase = getLastUserFromDbUseCase,
            checkUserEmailUseCase = checkUserEmailUseCase,
            setUserIdToSharedPrefsUseCase = setUserIdToSharedPrefsUseCase,
            saveUserToDbUseCase = saveUserToDbUseCase,
        )
    }

    @Provides
    fun provideSplashViewModelFactory(
        saveRoleToDbUseCase: SaveRoleToDbUseCase,
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    ): SplashViewModelFactory {
        return SplashViewModelFactory(
            saveRoleToDbUseCase = saveRoleToDbUseCase,
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
        )
    }
}