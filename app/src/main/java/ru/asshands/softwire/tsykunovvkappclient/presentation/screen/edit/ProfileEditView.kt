package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.edit

import com.arellomobile.mvp.MvpView
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.ProfileData

interface ProfileEditView : MvpView {
    fun showEditProfile(data: ProfileData)
    fun profileUpdated()
    fun profileNotUpdated()
}