package ru.asshands.softwire.tsykunovvkappclient

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import ru.asshands.softwire.tsykunovvkappclient.presentation.presentationModule
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router


class App : Application() {

    companion object {
        lateinit var INSTANCE: App
    }

    private lateinit var cicerone: Cicerone<Router>

    val router: Router
        get() = cicerone.router

    val navigatorHolder: NavigatorHolder
        get() = cicerone.navigatorHolder

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Android context
            androidContext(this@App)
            // modules
            modules(presentationModule)
        }

        INSTANCE = this
        cicerone = Cicerone.create()
    }
}