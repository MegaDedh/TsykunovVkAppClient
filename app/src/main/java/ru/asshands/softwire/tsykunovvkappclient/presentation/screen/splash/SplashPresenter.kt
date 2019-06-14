package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.splash

import android.os.Handler
import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.asshands.softwire.tsykunovvkappclient.data.storage.StorageInflate
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BasePresenter
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Screen
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.SessionRepository
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

@InjectViewState


class SplashPresenter @Inject constructor(
    private val sessionRepository: SessionRepository,
    private val storageInflate: StorageInflate,
    private val router: Router) : BasePresenter<SplashView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        storageInflate.addMainUser()
//https://tinyjpg.com/images/social/website.jpg
        for (i in 1L..100) {
            storageInflate.addPost(
                id = i,
                message = "DBMessage $i",
                contentUrl = "PIC",
                contentType = "https://loremflickr.com/300/200/nature?random=$i.id"
            )
        }


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