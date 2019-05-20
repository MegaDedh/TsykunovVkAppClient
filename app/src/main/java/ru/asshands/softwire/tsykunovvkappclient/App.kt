package ru.asshands.softwire.tsykunovvkappclient

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import ru.asshands.softwire.tsykunovvkappclient.dagger.DaggerAppComponent

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory().create(this)
}