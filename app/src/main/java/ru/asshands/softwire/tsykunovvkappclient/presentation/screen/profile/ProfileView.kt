package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile

import com.arellomobile.mvp.MvpView
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.feed.BaseMessage

interface ProfileView : MvpView {
    fun showProfile(firstName: String, surname: String, birthday: String, city: String)
    fun showFeed(items: List<BaseMessage>)
}