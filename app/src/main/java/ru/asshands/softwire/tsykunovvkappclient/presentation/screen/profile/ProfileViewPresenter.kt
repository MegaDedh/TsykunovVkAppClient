package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.Post
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.PostRepository
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.ProfileRepository
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.Paginator
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Screen
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.feed.CatMessage
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.feed.PostMessage
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class ProfileViewPresenter @Inject constructor(
    private val postRepository: PostRepository,
    private val profileRepository: ProfileRepository,
    private val router: Router) : MvpPresenter<ProfileView>() {

    private val paginator = Paginator(
        {
            postRepository.getPosts(it)
                .observeOn(AndroidSchedulers.mainThread())
                .doFinally { viewState.hideProgress() }
        },
        object : Paginator.ViewController<Post> {

            override fun showEmptyProgress(show: Boolean) {
                viewState.showProgress()
            }

            override fun showEmptyError(show: Boolean, error: Throwable?) {
                viewState.showErrorFeed()
            }

            override fun showEmptyView(show: Boolean) {
                viewState.showEmptyFeed()
            }

            override fun showData(show: Boolean, data: List<Post>) {
                viewState.showFeed(data.map { PostMessage(it.id, "Number ${it.id}",
                    "https://static.independent.co.uk/s3fs-public/thumbnails/image/2017/09/12/11/naturo-monkey-selfie.jpg?w968h681") })
            }

            override fun showErrorMessage(error: Throwable) {

            }

            override fun showRefreshProgress(show: Boolean) {
                viewState.showProgress()
            }

            override fun showPageProgress(show: Boolean) {
            }

        }
    )


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        paginator.refresh()
        getProfileData()
        getFeedData()
    }

    private fun getProfileData(){
        viewState.showProfile(profileRepository.getProfile())
    }

    fun loadPosts() {
        paginator.loadNewPage()
    }

    fun refreshPosts() {
        paginator.refresh()
    }

    private fun getFeedData() {
        //viewState.showFeed(postRepository.getAll())
    }

    fun logout() {
        //TODO("Сообщаем серверу что работа с аккаунтом завершена")
        router.replaceScreen(Screen.LoginScreen())
    }
    fun goToEditProfile() {
        //TODO("Сообщаем серверу что работа с аккаунтом завершена")
        router.navigateTo(Screen.ProfileEditScreen())
    }

    override fun onDestroy() {
        super.onDestroy()
        paginator.release()
    }
}