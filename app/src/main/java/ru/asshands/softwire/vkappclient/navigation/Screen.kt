package ru.asshands.softwire.vkappclient.navigation

import androidx.fragment.app.Fragment
import ru.asshands.softwire.vkappclient.fragment.SplashFragment
import ru.asshands.softwire.vkappclient.fragment.profile.ProfileViewFragment
import ru.asshands.softwire.vkappclient.fragment.edit.ProfileEditFragment
import ru.asshands.softwire.vkappclient.fragment.login.LoginFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screen(fragment: Fragment) : BaseScreen(fragment) {
    class SplashScreen : Screen(SplashFragment())
    class ProfileViewScreen(profileId: String) : Screen(ProfileViewFragment(profileId))
    class ProfileViewEditScreen : Screen(ProfileEditFragment())
    class LoginScreen : Screen(LoginFragment())
}

open class BaseScreen(private val fragment: Fragment) : SupportAppScreen() {
    override fun getFragment(): Fragment = fragment
}