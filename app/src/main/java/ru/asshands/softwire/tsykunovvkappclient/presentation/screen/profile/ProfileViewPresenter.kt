package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile

import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.asshands.softwire.tsykunovvkappclient.data.converter.Converter
import ru.asshands.softwire.tsykunovvkappclient.data.datasource.SessionDataSource
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.Post
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.PostRepository
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.ProfileRepository
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BasePresenter
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.Paginator
import ru.asshands.softwire.tsykunovvkappclient.presentation.entity.PostMessage
import ru.asshands.softwire.tsykunovvkappclient.presentation.entity.ProfileMessage
import ru.asshands.softwire.tsykunovvkappclient.presentation.model.ProfileData
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Screen
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.converter.PresentationConverter
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.converter.PresentationPostConverter
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.converter.PresentationProfileConverter
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class ProfileViewPresenter @Inject constructor(
    private val sessionDataSource: SessionDataSource,
    private val presentationPostConverter: PresentationConverter<Post, PostMessage>,
    private val presentationProfileConverter: PresentationConverter<User, ProfileMessage>,
    private val profileConverter: Converter<User, ProfileData>,
    private val postRepository: PostRepository,
    private val profileRepository: ProfileRepository,

    private val router: Router) : BasePresenter<ProfileView>() {

    private val paginator = Paginator(
        {
                postRepository.getPostsDb(it) // запрос из БД
             //   postRepository.getPosts(it) // запрос из API
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
                viewState.showFeed(data.map {presentationPostConverter.convert(it)})


/*            override fun showData(show: Boolean, data: List<Post>) {
                viewState.showFeed(data.map {
                    PostMessage(
                        it.id, "Number ${it.id}",
                        "PIC",
                        "https://loremflickr.com/300/200/nature?random=$it.id",
                        10
                    )
                })*/

/*                PostMessage(
                    it.id, "Number ${it.id}",
                    "https://loremflickr.com/300/200/nature?random=$it.id"
                )*/

                //"https://static.independent.co.uk/s3fs-public/thumbnails/image/2017/09/12/11/naturo-monkey-selfie.jpg?w968h681") })
                //"https://loremflickr.com/300/200/nature?random=$it.id"
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
        for (id in 1L..100){
        getPostData(id)
        }
    }

    private fun getPostData(id: Long) {
        postRepository.getPostDb(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.d("Room debug:$it")
                    // viewState.showProfile(profileConverter.convert(it))
                    //viewState.showProfile(presentationProfileConverter.convert(it))
                },
                {
                    Timber.e(it.message.orEmpty())
                }
            )
            .untilDestroy()
    }

    private fun getProfileData(id: Long) {
        profileRepository.getProfileDb(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    //Timber.d(it.toString())
                   // viewState.showProfile(profileConverter.convert(it))
                    viewState.showProfile(presentationProfileConverter.convert(it))
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