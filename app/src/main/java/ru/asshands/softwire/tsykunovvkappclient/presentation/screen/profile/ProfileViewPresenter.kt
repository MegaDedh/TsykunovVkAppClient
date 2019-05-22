package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.PostRepository
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.ProfileRepository
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Screen
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.feed.CatMessage
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.feed.PostMessage
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ProfileViewPresenter @Inject constructor(
    private val postRepository: PostRepository,
    private val profileRepository: ProfileRepository,
    private val router: Router) : MvpPresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        getProfileData()
        getFeedData()
    }



    private fun getProfileData(){
        viewState.showProfile(profileRepository.getProfile())
    }

    private fun getFeedData() {
        viewState.showFeed(postRepository.getAll())
    }

    fun logout() {
        //TODO("Сообщаем серверу что работа с аккаунтом завершена")
        router.replaceScreen(Screen.LoginScreen())
    }
    fun goToEditProfile() {
        //TODO("Сообщаем серверу что работа с аккаунтом завершена")
        router.navigateTo(Screen.ProfileEditScreen())
    }
}