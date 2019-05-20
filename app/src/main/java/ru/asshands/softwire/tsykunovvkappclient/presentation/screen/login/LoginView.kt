package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.login


import com.arellomobile.mvp.MvpView

interface LoginView : MvpView {
    fun accessDenied ()
    fun showForgotPasswordDialog (title: String, message: String)
}