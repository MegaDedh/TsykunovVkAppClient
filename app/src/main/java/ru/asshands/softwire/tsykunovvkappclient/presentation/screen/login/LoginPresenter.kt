package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.login

import android.content.Context
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.asshands.softwire.tsykunovvkappclient.R
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.SessionRepository
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BasePresenter
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.ProfileData
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Screen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
    class LoginPresenter @Inject constructor(
    private val sessionRepository: SessionRepository,
    private val router: Router) : BasePresenter<LoginView>() {

    fun login_old(login: String, password: String) {
        // TODO отправляем запрос на сервер, он должен вернуть profileID
        if (login == "test" && password == "123"){
            router.replaceScreen(Screen.ProfileViewScreen())
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

    fun login(name: String, password: String) {
        sessionRepository
            .login(name, password)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Log.d("data", it.toString())
                },
                {
                    Log.d("error", it.message)
                }
            )
            .untilDestroy()
    }
}