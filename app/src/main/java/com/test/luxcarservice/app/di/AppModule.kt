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

    ): AppointmentsViewModelFactory {
        return AppointmentsViewModelFactory(

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

    ): NotificationsViewModelFactory {
        return NotificationsViewModelFactory(

        )
    }

    @Provides
    fun provideOrdersViewModelFactory(

    ): OrdersViewModelFactory {
        return OrdersViewModelFactory(

        )
    }

    @Provides
    fun provideProductsViewModelFactory(

    ): ProductsViewModelFactory {
        return ProductsViewModelFactory(

        )
    }

    @Provides
    fun provideProfileViewModelFactory(

    ): ProfileViewModelFactory {
        return ProfileViewModelFactory(

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

    ): RootViewModelFactory {
        return RootViewModelFactory(

        )
    }

    @Provides
    fun provideServicesViewModelFactory(

    ): ServicesViewModelFactory {
        return ServicesViewModelFactory(

        )
    }

    @Provides
    fun provideSignInViewModelFactory(

    ): SignInViewModelFactory {
        return SignInViewModelFactory(

        )
    }

    @Provides
    fun provideSignUpViewModelFactory(

    ): SignUpViewModelFactory {
        return SignUpViewModelFactory(

        )
    }

    @Provides
    fun provideSplashViewModelFactory(

    ): SplashViewModelFactory {
        return SplashViewModelFactory(

        )
    }
}