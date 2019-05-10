package ru.asshands.softwire.vkappclient

import android.app.Application
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

        INSTANCE = this
        cicerone = Cicerone.create()
    }
}