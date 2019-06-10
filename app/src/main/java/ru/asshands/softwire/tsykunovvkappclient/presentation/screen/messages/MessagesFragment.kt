package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.messages

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.asshands.softwire.tsykunovvkappclient.R
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BaseFragment
import javax.inject.Inject

class MessagesFragment: BaseFragment(R.layout.fragment_messages, true), MessagesView{

    @Inject
    @InjectPresenter
    lateinit var presenter: MessagesPresenter

    @ProvidePresenter
    fun providePresenter(): MessagesPresenter = presenter

}