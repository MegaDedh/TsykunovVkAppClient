package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.messages

import com.arellomobile.mvp.InjectViewState
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BasePresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class MessagesPresenter @Inject constructor(
    private val router: Router) : BasePresenter<MessagesView>() {
}