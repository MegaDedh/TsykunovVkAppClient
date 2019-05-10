package ru.asshands.softwire.vkappclient.fragment.login


import com.arellomobile.mvp.MvpView

interface LoginView : MvpView {
    fun accessAllowed (profileId: String)
    fun accessDenied ()
    fun showForgotPasswordDialog (title: String, message: String)
}