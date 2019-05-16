package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.edit

import com.arellomobile.mvp.MvpView

interface ProfileEditView : MvpView {
    fun showEditProfile(firstName: String, surname: String, birthday: String, city: String)
    fun profileUpdated()
    fun profileNotUpdated()
}