package ru.asshands.softwire.tsykunovvkappclient.dagger

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.asshands.softwire.tsykunovvkappclient.App
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NavigationModule::class,
    AndroidSupportInjectionModule::class,
    DataModule::class
])
interface AppComponent: AndroidInjector<App> {

    @Component.Factory
    interface Builder: AndroidInjector.Factory<App>

}