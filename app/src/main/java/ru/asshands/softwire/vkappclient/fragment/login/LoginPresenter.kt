package ru.asshands.softwire.vkappclient.fragment.login

import android.content.Context
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.asshands.softwire.vkappclient.R
import ru.asshands.softwire.vkappclient.common.ProfileData

@InjectViewState
class LoginPresenter : MvpPresenter<LoginView>() {

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