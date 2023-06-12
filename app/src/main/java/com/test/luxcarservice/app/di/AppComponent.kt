package com.test.luxcarservice.app.di

import com.test.luxcarservice.app.presentation.screen.add_product.AddProductFragment
import com.test.luxcarservice.app.presentation.screen.add_service.AddServiceFragment
import com.test.luxcarservice.app.presentation.screen.appointments.AppointmentsFragment
import com.test.luxcarservice.app.presentation.screen.information.InformationFragment
import com.test.luxcarservice.app.presentation.screen.notifications.NotificationsFragment
import com.test.luxcarservice.app.presentation.screen.orders.OrdersFragment
import com.test.luxcarservice.app.presentation.screen.products.ProductsFragment
import com.test.luxcarservice.app.presentation.screen.profile.ProfileFragment
import com.test.luxcarservice.app.presentation.screen.profile_settings.ProfileSettingsFragment
import com.test.luxcarservice.app.presentation.screen.root.RootFragment
import com.test.luxcarservice.app.presentation.screen.services.ServicesFragment
import com.test.luxcarservice.app.presentation.screen.signin.SignInFragment
import com.test.luxcarservice.app.presentation.screen.signup.SignUpFragment
import com.test.luxcarservice.app.presentation.screen.splash.SplashFragment
import dagger.Component

@Component(modules = [AppModule::class, DomainModule::class, DataModule::class])
interface AppComponent {

    fun injectAddProductFragment(addProductFragment: AddProductFragment)

    fun injectAddServiceFragment(addServiceFragment: AddServiceFragment)

    fun injectAppointmentsFragment(appointmentsFragment: AppointmentsFragment)

    fun injectInformationFragment(informationFragment: InformationFragment)

    fun injectNotificationsFragment(notificationsFragment: NotificationsFragment)

    fun injectOrdersFragment(ordersFragment: OrdersFragment)

    fun injectProductsFragment(productsFragment: ProductsFragment)

    fun injectProfileFragment(profileFragment: ProfileFragment)

    fun injectProfileSettingsFragment(profileSettingsFragment: ProfileSettingsFragment)

    fun injectRootFragment(rootFragment: RootFragment)

    fun injectServicesFragment(servicesFragment: ServicesFragment)

    fun injectSignInFragment(signInFragment: SignInFragment)

    fun injectSignUpFragment(signUpFragment: SignUpFragment)

    fun injectSplashFragment(splashFragment: SplashFragment)
}