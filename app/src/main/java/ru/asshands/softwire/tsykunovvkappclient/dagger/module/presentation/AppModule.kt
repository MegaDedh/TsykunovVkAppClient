package ru.asshands.softwire.tsykunovvkappclient.dagger.module.presentation

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.asshands.softwire.tsykunovvkappclient.dagger.ActivityScope
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.main.MainActivity

@Module
interface AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun provideMainActivity() : MainActivity
}