package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.main



import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import org.koin.core.KoinComponent
import org.koin.core.get
import org.koin.core.inject
import ru.asshands.softwire.tsykunovvkappclient.App
import ru.asshands.softwire.tsykunovvkappclient.R
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Navigator
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Screen
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator


class MainActivity : AppCompatActivity(), MainView, KoinComponent {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter(): MainPresenter = get()

    private val navigatorHolder by inject<NavigatorHolder>()
    private val router by inject<Router>()


    private lateinit var navigator: SupportAppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigator = Navigator(this, supportFragmentManager, R.id.content)

        //App.INSTANCE.router.newRootScreen(Screen.ProfileViewScreen())
     //   App.INSTANCE.router.newRootScreen(Screen.SplashScreen())
        router.newRootScreen(Screen.SplashScreen())
    }

    override fun onResume() {
        super.onResume()
        //App.INSTANCE.navigatorHolder.setNavigator(navigator)
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        //App.INSTANCE.navigatorHolder.removeNavigator()
        navigatorHolder.removeNavigator()
    }
}