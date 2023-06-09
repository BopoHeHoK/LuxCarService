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
import com.test.luxcarservice.domain.use_case.DeleteProductByIdFromDbUseCase
import com.test.luxcarservice.domain.use_case.DeleteServiceByIdFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetAppointmentsByUserIdFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetAppointmentsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetLastAppointmentFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetLastShopCartFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetLastUserFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetNotificationsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetProductsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetRolesFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetServicesFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetShopCartsByUserIdFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetShopCartsFromDbUseCase
import com.test.luxcarservice.domain.use_case.GetUserFromDbByEmailUseCase
import com.test.luxcarservice.domain.use_case.GetUserFromDbByIdUseCase
import com.test.luxcarservice.domain.use_case.GetUserIdFromSharedPrefsUseCase
import com.test.luxcarservice.domain.use_case.GetUsersFromDbUseCase
import com.test.luxcarservice.domain.use_case.SaveAppointmentToDbUseCase
import com.test.luxcarservice.domain.use_case.SaveProductToDbUseCase
import com.test.luxcarservice.domain.use_case.SaveRoleToDbUseCase
import com.test.luxcarservice.domain.use_case.SaveServiceToDbUseCase
import com.test.luxcarservice.domain.use_case.SaveShopCartToDbUseCase
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
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        getAppointmentsFromDbUseCase: GetAppointmentsFromDbUseCase,
        getAppointmentsByUserIdFromDbUseCase: GetAppointmentsByUserIdFromDbUseCase,
        getRolesFromDbUseCase: GetRolesFromDbUseCase,
        getServicesFromDbUseCase: GetServicesFromDbUseCase,
        getUsersFromDbUseCase: GetUsersFromDbUseCase,
        getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
    ): AppointmentsViewModelFactory {
        return AppointmentsViewModelFactory(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getAppointmentsFromDbUseCase = getAppointmentsFromDbUseCase,
            getAppointmentsByUserIdFromDbUseCase = getAppointmentsByUserIdFromDbUseCase,
            getRolesFromDbUseCase = getRolesFromDbUseCase,
            getServicesFromDbUseCase = getServicesFromDbUseCase,
            getUsersFromDbUseCase = getUsersFromDbUseCase,
            getUserFromDbByIdUseCase = getUserFromDbByIdUseCase,
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
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        getShopCartsFromDbUseCase: GetShopCartsFromDbUseCase,
        getShopCartsByUserIdFromDbUseCase: GetShopCartsByUserIdFromDbUseCase,
        getRolesFromDbUseCase: GetRolesFromDbUseCase,
        getProductsFromDbUseCase: GetProductsFromDbUseCase,
        getUsersFromDbUseCase: GetUsersFromDbUseCase,
        getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
    ): OrdersViewModelFactory {
        return OrdersViewModelFactory(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getShopCartsFromDbUseCase = getShopCartsFromDbUseCase,
            getShopCartsByUserIdFromDbUseCase = getShopCartsByUserIdFromDbUseCase,
            getRolesFromDbUseCase = getRolesFromDbUseCase,
            getProductsFromDbUseCase = getProductsFromDbUseCase,
            getUsersFromDbUseCase = getUsersFromDbUseCase,
            getUserFromDbByIdUseCase = getUserFromDbByIdUseCase,
        )
    }

    @Provides
    fun provideProductsViewModelFactory(
        getProductsFromDbUseCase: GetProductsFromDbUseCase,
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        getRolesFromDbUseCase: GetRolesFromDbUseCase,
        getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
        getShopCartsFromDbUseCase: GetShopCartsFromDbUseCase,
        getLastShopCartFromDbUseCase: GetLastShopCartFromDbUseCase,
        saveShopCartToDbUseCase: SaveShopCartToDbUseCase,
        deleteProductByIdFromDbUseCase: DeleteProductByIdFromDbUseCase,
    ): ProductsViewModelFactory {
        return ProductsViewModelFactory(
            getProductsFromDbUseCase = getProductsFromDbUseCase,
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getRolesFromDbUseCase = getRolesFromDbUseCase,
            getUserFromDbByIdUseCase = getUserFromDbByIdUseCase,
            getShopCartsFromDbUseCase = getShopCartsFromDbUseCase,
            getLastShopCartFromDbUseCase = getLastShopCartFromDbUseCase,
            saveShopCartToDbUseCase = saveShopCartToDbUseCase,
            deleteProductByIdFromDbUseCase = deleteProductByIdFromDbUseCase,
        )
    }

    @Provides
    fun provideProfileViewModelFactory(
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        setUserIdToSharedPrefsUseCase: SetUserIdToSharedPrefsUseCase,
        getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
    ): ProfileViewModelFactory {
        return ProfileViewModelFactory(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            setUserIdToSharedPrefsUseCase = setUserIdToSharedPrefsUseCase,
            getUserFromDbByIdUseCase = getUserFromDbByIdUseCase,
        )
    }

    @Provides
    fun provideProfileSettingsViewModelFactory(
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
        saveUserToDbUseCase: SaveUserToDbUseCase,
    ): ProfileSettingsViewModelFactory {
        return ProfileSettingsViewModelFactory(
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getUserFromDbByIdUseCase = getUserFromDbByIdUseCase,
            saveUserToDbUseCase = saveUserToDbUseCase,
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
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
        getRolesFromDbUseCase: GetRolesFromDbUseCase,
        getUserFromDbByIdUseCase: GetUserFromDbByIdUseCase,
        getAppointmentsFromDbUseCase: GetAppointmentsFromDbUseCase,
        getLastAppointmentFromDbUseCase: GetLastAppointmentFromDbUseCase,
        saveAppointmentToDbUseCase: SaveAppointmentToDbUseCase,
        deleteServiceByIdFromDbUseCase: DeleteServiceByIdFromDbUseCase,
    ): ServicesViewModelFactory {
        return ServicesViewModelFactory(
            getServicesFromDbUseCase = getServicesFromDbUseCase,
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
            getRolesFromDbUseCase = getRolesFromDbUseCase,
            getUserFromDbByIdUseCase = getUserFromDbByIdUseCase,
            getAppointmentsFromDbUseCase = getAppointmentsFromDbUseCase,
            getLastAppointmentFromDbUseCase = getLastAppointmentFromDbUseCase,
            saveAppointmentToDbUseCase = saveAppointmentToDbUseCase,
            deleteServiceByIdFromDbUseCase = deleteServiceByIdFromDbUseCase,
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
        saveServiceToDbUseCase: SaveServiceToDbUseCase,
        saveProductToDbUseCase: SaveProductToDbUseCase,
        getUserIdFromSharedPrefsUseCase: GetUserIdFromSharedPrefsUseCase,
    ): SplashViewModelFactory {
        return SplashViewModelFactory(
            saveRoleToDbUseCase = saveRoleToDbUseCase,
            saveServiceToDbUseCase = saveServiceToDbUseCase,
            saveProductToDbUseCase = saveProductToDbUseCase,
            getUserIdFromSharedPrefsUseCase = getUserIdFromSharedPrefsUseCase,
        )
    }
}