package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.edit

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import ru.asshands.softwire.tsykunovvkappclient.data.converter.Converter
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.ProfileRepository
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.UserRepository
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BasePresenter
import ru.asshands.softwire.tsykunovvkappclient.presentation.model.ProfileData
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Screen
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.ProfileView
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class ProfileEditPresenter @Inject constructor(
    private val userRepository: UserRepository,
    private val profileRepository: ProfileRepository,
    private val profileConverter: Converter<User, ProfileData>,
    private val router: Router) : BasePresenter<ProfileEditView>() {


    fun getProfileData(id: Long) {
        profileRepository.getProfileDb(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.showEditProfile(profileConverter.convert(it))
                },
                {
                    Timber.e(it.message.orEmpty())
                }
            )
            .untilDestroy()
    }



    fun saveChanges (id: Long, firstName: String, lastname: String, birthday: String, city: String){
        userRepository.update(
            User(
                id = id,
                phone = "555",
                firstName = firstName,
                lastName = lastname,
                birthday = birthday,
                city = city,
                avatar = "https://pp.userapi.com/c850016/v850016044/1a25fc/cHZ5EmlnW5o.jpg"
            ), "root"
        )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.profileUpdated()
                },
                {
                    Timber.e(it.message.orEmpty())
                    viewState.profileNotUpdated()
                }
            )
            .untilDestroy()
    }







/*    fun saveChanges (id: Long, firstName: String, lastname: String, birthday: String, city: String){
        //имитация работ на сервере
        doAsync {
            Thread.sleep(3000)
            uiThread {

                profileRepository.getProfileDb(id)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                        {
                            viewState.profileUpdated()
                        },
                        {
                            Timber.e(it.message.orEmpty())
                            viewState.profileNotUpdated()
                        }
                    )
                    .untilDestroy()
            }
        }
    }*/




/*        fun saveChanges (firstName: String, lastname: String, birthday: String, city: String){
            //имитация работ на сервере
            doAsync {
                Thread.sleep(3000)
                uiThread {
           //         var deliveryStatus = profileRepository.setProfile(ProfileData(firstName, surname, birthday, city))
                    if (true) viewState.profileUpdated()
                    else viewState.profileNotUpdated()
                }
            }
        }*/
    fun goToProfileViewScreen() {
        router.replaceScreen(Screen.ProfileViewScreen())
    }
}