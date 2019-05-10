package ru.asshands.softwire.vkappclient.fragment.edit

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import ru.asshands.softwire.vkappclient.model.VkApi

@InjectViewState
class ProfileEditPresenter : MvpPresenter<ProfileEditView>() {
    private val vkServer = VkApi()

        fun getProfile(){
            // TODO сделать DataClass c данными профиля и вынести работу в vkServer
            val firstName = "Alexey"
            val surname = "Tsykunov"
            val birthday = "21.05.1988"
            val city = "Tomsk"
            viewState.showEditProfile(firstName, surname, birthday, city)
        }

        fun saveChanges (firstName: String, surname: String, birthday: String, city: String){
            //имитация работ на сервере
            doAsync {
                Thread.sleep(3000)
                uiThread {
                    var deliveryStatus = vkServer.setProfileData(firstName, surname, birthday, city)
                    if (deliveryStatus == 0) viewState.profileUpdated()
                    else viewState.profileNotUpdated()
                }
            }
        }
}