package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.addpost

import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.asshands.softwire.tsykunovvkappclient.data.storage.StorageInflate
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BasePresenter
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Screen
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class AddPostPresenter  @Inject constructor(
    private val storageInflate: StorageInflate,
    private val router: Router) : BasePresenter<AddPostView>() {


    fun addPost (text: String, picUrl: String){
        storageInflate.addPost(
            id = (101L..1000).random(),
            message = text,
            contentType = "PIC",
            contentUrl = picUrl
        )
        Timber.e("addPost $text $picUrl")
       /* userRepository.update(
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
            .untilDestroy()*/
        viewState.postAddedSuccessful()
    }



    fun goToProfileViewScreen() {
        router.replaceScreen(Screen.ProfileViewScreen())
    }

}