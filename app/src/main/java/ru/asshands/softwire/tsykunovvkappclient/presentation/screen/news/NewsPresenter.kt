package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.news

import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.ProfileRepository
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.SessionRepository
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BasePresenter
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Screen
import ru.terrakok.cicerone.Router
import timber.log.Timber
import javax.inject.Inject

@InjectViewState
class NewsPresenter @Inject constructor(
    private val ProfileRepository: ProfileRepository,
    private val router: Router) : BasePresenter<NewsView>() {


    fun getProfile(id: Long) {

        ProfileRepository.getProfileDb(id)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.d(it.toString())
                },
                {
                    Timber.e(it.message.orEmpty())
                }
            )
            .untilDestroy()
    }
}