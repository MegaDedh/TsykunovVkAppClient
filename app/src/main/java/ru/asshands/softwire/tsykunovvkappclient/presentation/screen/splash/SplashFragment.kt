package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.splash

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.asshands.softwire.tsykunovvkappclient.App
import ru.asshands.softwire.tsykunovvkappclient.R
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Screen
import kotlinx.android.synthetic.main.frament_splash.*
import org.koin.core.KoinComponent
import org.koin.core.get
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BaseFragment


class SplashFragment : BaseFragment(R.layout.frament_splash), SplashView, KoinComponent {

    @InjectPresenter
    lateinit var presenter: SplashPresenter

    @ProvidePresenter
    fun providePresenter(): SplashPresenter = get()
}

/*
class SplashFragment : BaseFragment(R.layout.frament_splash) {

    override fun onResume() {
        super.onResume()
        asd.postDelayed({
            App.INSTANCE.router.replaceScreen(Screen.LoginScreen())
        }, 3000)
    }

}*/