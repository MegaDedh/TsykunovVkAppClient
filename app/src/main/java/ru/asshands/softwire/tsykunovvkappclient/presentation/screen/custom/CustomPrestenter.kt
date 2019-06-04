package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.custom

import com.arellomobile.mvp.InjectViewState
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BasePresenter
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.login.LoginView
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class CustomPresenter @Inject constructor(
    private val router: Router
) : BasePresenter<CustomView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

    }
}