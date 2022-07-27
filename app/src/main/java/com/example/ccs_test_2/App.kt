package com.example.ccs_test_2

import android.app.Application
import com.example.ccs_test_2.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(
                listOf(
                    valuteListScreenDataModule,
                    valuteListDomainModule,
                    valuteListScreenPresentationModule,
                    valuteFavoriteScreenDomainModule,
                    valuteFavoriteScreenDataModule,
                    valuteFavoriteScreenPresentationModule
                )
            )
        }
    }
}