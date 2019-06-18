package ru.asshands.softwire.tsykunovvkappclient.presentation.navigation

import androidx.fragment.app.Fragment
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.addpost.AddPostFragment
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.custom.CustomFragment
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.splash.SplashFragment
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.ProfileViewFragment
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.edit.ProfileEditFragment
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.login.LoginFragment
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.messages.MessagesFragment
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.news.NewsFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screen(fragment: Fragment) : BaseScreen(fragment) {
    class SplashScreen : Screen(SplashFragment())
    class ProfileViewScreen : Screen(ProfileViewFragment.createInstance())
    class ProfileEditScreen : Screen(ProfileEditFragment())
    class MessagesScreen : Screen(MessagesFragment())
    class NewsScreen : Screen(NewsFragment())
    class LoginScreen : Screen(LoginFragment())
    class AddPostScreen : Screen(AddPostFragment())
    class CustomScreen : Screen(CustomFragment())
}

open class BaseScreen(private val fragment: Fragment) : SupportAppScreen() {
    override fun getFragment(): Fragment = fragment
}