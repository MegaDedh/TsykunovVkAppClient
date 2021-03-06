package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.main

import com.arellomobile.mvp.InjectViewState
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BasePresenter
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Screen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor (private val router: Router) : BasePresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(Screen.SplashScreen())
    }

    fun goToProfileView(){
        router.navigateTo(Screen.ProfileViewScreen())
    }

    fun goToMessages(){
        router.navigateTo(Screen.MessagesScreen())
    }

    fun goToNews(){
        router.navigateTo(Screen.AddPostScreen())
    }
}