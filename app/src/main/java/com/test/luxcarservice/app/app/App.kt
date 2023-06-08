package com.test.luxcarservice.app.app

import android.app.Application
import com.test.luxcarservice.app.di.AppComponent
import com.test.luxcarservice.app.di.AppModule
import com.test.luxcarservice.app.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(context = this))
            .build()
    }
}