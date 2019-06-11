package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile

import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.asshands.softwire.tsykunovvkappclient.data.converter.Converter
import ru.asshands.softwire.tsykunovvkappclient.data.converter.UserConverter
import ru.asshands.softwire.tsykunovvkappclient.data.datasource.SessionDataSource
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.Post
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.PostRepository
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.ProfileRepository
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BasePresenter
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.Paginator
import ru.asshands.softwire.tsykunovvkappclient.presentation.model.ProfileData
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Screen
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.feed.CatMessage
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.feed.PostMessage
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class ProfileViewPresenter @Inject constructor(
    private val sessionDataSource: SessionDataSource,
    private val profileConverter: Converter<User, ProfileData>,
    private val postRepository: PostRepository,
    private val profileRepository: ProfileRepository,
    private val router: Router) : BasePresenter<ProfileView>() {

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
        getProfileData(100200300)
    }

    private fun getProfileData(id: Long) {
        profileRepository.getProfileDb(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    //Timber.d(it.toString())
                    viewState.showProfile(profileConverter.convert(it))
                },
                {
                    Timber.e(it.message.orEmpty())
                }
            )
            .untilDestroy()
    }

    fun loadPosts() {
        paginator.loadNewPage()
    }

    fun refreshPosts() {
        paginator.refresh()
    }

    fun logout() {
        sessionDataSource.clearToken()
        router.replaceScreen(Screen.LoginScreen())
    }
    fun goToEditProfile() {
        router.navigateTo(Screen.ProfileEditScreen())
    }

    override fun onDestroy() {
        super.onDestroy()
        paginator.release()
    }
}