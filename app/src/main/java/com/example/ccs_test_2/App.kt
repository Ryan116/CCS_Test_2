package com.example.ccs_test_2

import android.app.Application
import com.example.ccs_test_2.di.dataModule
import com.example.ccs_test_2.di.domainModule
import com.example.ccs_test_2.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    dataModule,
                    domainModule,
                    presentationModule
                )
            )
        }
    }
}