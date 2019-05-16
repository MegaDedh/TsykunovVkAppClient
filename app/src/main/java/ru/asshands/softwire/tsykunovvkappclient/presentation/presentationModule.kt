package ru.asshands.softwire.tsykunovvkappclient.presentation

import org.koin.dsl.module
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.main.MainPresenter
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.splash.SplashPresenter

import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

val presentationModule = module {

    single { Cicerone.create() }
    single { get<Cicerone<Router>>().router }
    single { get<Cicerone<Router>>().navigatorHolder }

    factory { SplashPresenter.SplashPresenter(get()) }
    factory { MainPresenter(get()) }
}