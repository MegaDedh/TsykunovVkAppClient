package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile

import com.arellomobile.mvp.MvpView
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.ProfileData
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.feed.BaseMessage

interface ProfileView : MvpView {
    fun showProfile(data: ProfileData)
    fun showFeed(items: List<BaseMessage>)
    fun showEmptyFeed()
    fun showProgress()
    fun hideProgress()
    fun showErrorFeed()
}