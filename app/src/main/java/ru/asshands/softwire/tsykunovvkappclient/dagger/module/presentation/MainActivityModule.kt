package ru.asshands.softwire.tsykunovvkappclient.dagger.module.presentation

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.asshands.softwire.tsykunovvkappclient.dagger.FragmentScope
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.custom.CustomFragment
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.edit.ProfileEditFragment
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.login.LoginFragment
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.messages.MessagesFragment
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.news.NewsFragment
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.ProfileViewFragment
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.splash.SplashFragment

@Module
interface MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun provideSplashFragment(): SplashFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideLoginFragment(): LoginFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideProfileViewFragment(): ProfileViewFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideProfileEdirFragment(): ProfileEditFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideMessagesFragment(): MessagesFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideNewsFragment(): NewsFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideCustomFragment(): CustomFragment

}