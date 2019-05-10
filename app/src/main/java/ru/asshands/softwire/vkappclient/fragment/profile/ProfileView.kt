package ru.asshands.softwire.vkappclient.fragment.profile

import com.arellomobile.mvp.MvpView

interface ProfileView : MvpView {
    fun showProfile(firstName: String, surname: String, birthday: String, city: String)
    fun showFeed(items: List<BaseMessage>)
    fun goToLoginScreen()
}