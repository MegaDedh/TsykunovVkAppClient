package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.news

import com.arellomobile.mvp.InjectViewState
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class NewsPresenter @Inject constructor(
    private val router: Router) : BasePresenter<NewsView>() {
}