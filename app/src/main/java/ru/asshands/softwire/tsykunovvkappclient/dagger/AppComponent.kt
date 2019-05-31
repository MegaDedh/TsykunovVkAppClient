package ru.asshands.softwire.tsykunovvkappclient.dagger

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import ru.asshands.softwire.tsykunovvkappclient.App
import ru.asshands.softwire.tsykunovvkappclient.dagger.module.data.DataModule
import ru.asshands.softwire.tsykunovvkappclient.dagger.module.data.NetworkModule
import ru.asshands.softwire.tsykunovvkappclient.dagger.module.presentation.PresentationModule
import javax.inject.Singleton

@Singleton
//@Component – мост между @Inject и @Module
@Component(modules = [
 //   AppModule::class,
 //   NavigationModule::class,
    AndroidSupportInjectionModule::class,
    DataModule::class,
    PresentationModule::class

])
interface AppComponent: AndroidInjector<App> {

    @Component.Factory
    interface Builder: AndroidInjector.Factory<App>

}