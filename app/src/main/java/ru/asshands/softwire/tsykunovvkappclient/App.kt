package ru.asshands.softwire.tsykunovvkappclient

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.asshands.softwire.tsykunovvkappclient.dagger.DaggerAppComponent
import timber.log.Timber

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent
            .factory()
            .create(this)

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}