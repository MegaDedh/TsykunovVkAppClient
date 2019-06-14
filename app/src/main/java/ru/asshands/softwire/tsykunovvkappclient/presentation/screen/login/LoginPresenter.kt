package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.login

import android.content.Context
import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.asshands.softwire.tsykunovvkappclient.R
import ru.asshands.softwire.tsykunovvkappclient.data.database.dao.UserDao
import ru.asshands.softwire.tsykunovvkappclient.data.database.entity.UserEntity
import ru.asshands.softwire.tsykunovvkappclient.data.datasource.SessionDataSource
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
    private val sessionDataSource: SessionDataSource,
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

        sessionRepository.login(phone, password)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.d("Room debug:$it")
                    sessionDataSource.saveToken(it.id.toString())
                    router.replaceScreen(Screen.ProfileViewScreen())
                },
                {
                    Timber.e(it.message.orEmpty())
                    viewState.accessDenied()
                }
            )
            .untilDestroy()
    }

    fun goToCustomView(){
        router.replaceScreen(Screen.CustomScreen())
    }

}