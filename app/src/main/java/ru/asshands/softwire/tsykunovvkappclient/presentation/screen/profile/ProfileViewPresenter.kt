package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Screen
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.feed.CatMessage
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.feed.PostMessage
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ProfileViewPresenter @Inject constructor(private val router: Router) : MvpPresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        getProfileData()
        getFeedData()
    }

    private fun getProfileData(){
        val firstName = "Alexey"
        val surname = "Tsykunov"
        val birthday = "21.05.1988"
        val city = "Tomsk"
        viewState.showProfile(firstName, surname, birthday, city)
    }

    private fun getFeedData() {
        viewState.showFeed((1..100).map {
            if (it % 5 == 0) {
                CatMessage(
                    it,
                    "https://ichef.bbci.co.uk/images/ic/720x405/p0517py6.jpg"
                )
            } else {
                PostMessage(
                    it,
                    "Message".repeat(30),
                    "https://picsum.photos/id/$it/200/300"
                )
            }
        })
    }

    fun logout() {
        //TODO("Сообщаем серверу что работа с аккаунтом завершена")
        router.replaceScreen(Screen.LoginScreen())
        //viewState.goToLoginScreen()
    }
    fun goToEditProfile() {
        //TODO("Сообщаем серверу что работа с аккаунтом завершена")
        router.replaceScreen(Screen.ProfileViewEditScreen())
        //viewState.goToLoginScreen()
    }
}