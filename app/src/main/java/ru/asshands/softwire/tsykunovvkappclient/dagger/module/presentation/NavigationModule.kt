package ru.asshands.softwire.tsykunovvkappclient.dagger.module.presentation

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Singleton

@Module // классы, , чьи методы “предоставляют зависимости”
class NavigationModule {

    @Singleton
    @Provides //@Provide – методы внутри @Module, “говорящие Dagger, как мы хотим сконструировать и предоставить зависимость“
    fun provideCicerone(): Cicerone<Router> = Cicerone.create()

    @Singleton
    @Provides
    fun provideNavigationHolder(cicerone: Cicerone<Router>): NavigatorHolder = cicerone.navigatorHolder

    @Singleton
    @Provides
    fun provideRouter(cicerone: Cicerone<Router>): Router = cicerone.router
}