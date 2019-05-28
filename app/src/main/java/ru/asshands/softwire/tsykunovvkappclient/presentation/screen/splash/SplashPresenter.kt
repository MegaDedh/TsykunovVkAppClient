package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.splash

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BasePresenter
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Screen
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.SessionRepository
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState


class SplashPresenter @Inject constructor(
    private val sessionRepository: SessionRepository,
    private val router: Router) : BasePresenter<SplashView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        Handler().postDelayed({
            router.newRootScreen(
                if (sessionRepository.isAuth()) {
                    //ProfileData.ProfileID="ProfileID"
                    Screen.ProfileViewScreen()
                } else {
                    Screen.LoginScreen()
                }
            )
        }, 2000)
    }
}