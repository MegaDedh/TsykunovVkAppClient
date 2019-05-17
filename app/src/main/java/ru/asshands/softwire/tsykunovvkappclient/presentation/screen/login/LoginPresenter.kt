package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.login

import android.content.Context
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.asshands.softwire.tsykunovvkappclient.R
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BasePresenter
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.ProfileData
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.splash.SplashView
import ru.terrakok.cicerone.Router

@InjectViewState
    class LoginPresenter : BasePresenter<LoginView>() {
//(private val router: Router)
    fun login(login: String, password: String) {
        // TODO отправляем запрос на сервер, он должен вернуть profileID
        if (login == "test" && password == "123"){
            ProfileData.ProfileID = "profileID"
        viewState.accessAllowed(ProfileData.ProfileID)
    }
        else{
            viewState.accessDenied()
        }
    }

    fun onClickForgotPasswordBtn (context: Context){
        viewState.showForgotPasswordDialog(
            context.getString(R.string.app_name),
            context.getString(R.string.remember_password))
    }
}