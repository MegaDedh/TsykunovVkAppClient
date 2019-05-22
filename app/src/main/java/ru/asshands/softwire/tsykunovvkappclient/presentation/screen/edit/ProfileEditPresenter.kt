package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.edit

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.PostRepository
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.ProfileRepository
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BasePresenter
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.ProfileData
import ru.asshands.softwire.tsykunovvkappclient.presentation.model.VkApi
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Screen
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.login.LoginView
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ProfileEditPresenter @Inject constructor(
    private val profileRepository: ProfileRepository,
    private val router: Router) : MvpPresenter<ProfileEditView>() {
    private val vkServer = VkApi()

        fun getProfile(){
            viewState.showEditProfile(profileRepository.getProfile())
        }

        fun saveChanges (firstName: String, surname: String, birthday: String, city: String){
            //имитация работ на сервере
            doAsync {
                Thread.sleep(3000)
                uiThread {
                    var deliveryStatus = profileRepository.setProfile(ProfileData(firstName, surname, birthday, city))
                    if (deliveryStatus == 0) viewState.profileUpdated()
                    else viewState.profileNotUpdated()
                }
            }
        }
    fun goToProfileViewScreen() {
        router.replaceScreen(Screen.ProfileViewScreen())
    }
}