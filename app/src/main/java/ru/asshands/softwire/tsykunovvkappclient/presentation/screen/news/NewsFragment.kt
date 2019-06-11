package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.news

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.asshands.softwire.tsykunovvkappclient.R
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BaseFragment
import javax.inject.Inject

class NewsFragment: BaseFragment(R.layout.fragment_news, true), NewsView{

    @Inject
    @InjectPresenter
    lateinit var presenter: NewsPresenter

    @ProvidePresenter
    fun providePresenter(): NewsPresenter = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getProfile(100200300)
    }
}