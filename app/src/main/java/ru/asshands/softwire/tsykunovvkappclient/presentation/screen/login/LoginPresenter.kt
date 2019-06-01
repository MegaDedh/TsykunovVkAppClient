package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.login

import android.content.Context
import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.asshands.softwire.tsykunovvkappclient.R
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.SessionRepository
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.UserRepository
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BasePresenter
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Screen
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
    class LoginPresenter @Inject constructor(
    private val sessionRepository: SessionRepository,
    private val userRepository: UserRepository,
    private val router: Router) : BasePresenter<LoginView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    //    login("555", "root")
    }


    fun onClickForgotPasswordBtn (context: Context){
        viewState.showForgotPasswordDialog(
            context.getString(R.string.app_name),
            context.getString(R.string.remember_password))
    }

    fun login(phone: String, password: String) {
        userRepository
            .create(
                User(
                    id = 100200300,
                    phone = phone,
                    firstName = "dbUserName",
                    lastName = "dbUserLastName",
                    avatar = "avatark.jpg"
                ), password
            )
            .flatMap {
                sessionRepository.login(phone, password)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.d(it.toString())
                },
                {
                    Timber.e(it.message.orEmpty())
                }
            )
            .untilDestroy()
    }

    fun login_old(login: String, password: String) {
        // TODO отправляем запрос на сервер, он должен вернуть profileID
        if (login == "test" && password == "123"){
            router.replaceScreen(Screen.LoginScreen())
        }
        else{
            viewState.accessDenied()
        }
    }
}