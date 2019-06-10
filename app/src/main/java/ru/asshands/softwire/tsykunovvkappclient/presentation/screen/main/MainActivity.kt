package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.main

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.asshands.softwire.tsykunovvkappclient.presentation.moxy.MvpAppCompatActivity
import ru.asshands.softwire.tsykunovvkappclient.R
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Navigator
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import kotlinx.android.synthetic.main.activity_main.*
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BottomNavigationController
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject


class MainActivity :
    MvpAppCompatActivity(),
    HasSupportFragmentInjector,
    MainView,
    BottomNavigationController{

    companion object {
        const val ARG_IS_SHOW_NAVIGATION = "ARG_IS_SHOW_NAVIGATION"
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter(): MainPresenter = presenter

    @Inject
    lateinit var supportFragmentInjectorImpl: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = supportFragmentInjectorImpl

    private var isShowNavigation: Boolean = false

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator: SupportAppNavigator by lazy {
        Navigator(this, supportFragmentManager, R.id.content)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        savedInstanceState?.let {
            isShowNavigation = it.getBoolean(ARG_IS_SHOW_NAVIGATION)
        }
        initBottomNavigation()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(ARG_IS_SHOW_NAVIGATION, isShowNavigation)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun showNavigation() {
        if (isShowNavigation.not()) {
            bottomNavigation.animate().apply {
                duration = 150

                translationY(-bottomNavigation.height.toFloat())
                start()
            }
            isShowNavigation = true
        }
    }

    override fun hideNavigation() {
        if (isShowNavigation) {
            bottomNavigation.animate().apply {
                duration = 150

                translationY(bottomNavigation.height.toFloat())
                start()
            }
            isShowNavigation = false
        }
    }

    private fun initBottomNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_profile -> {
                    presenter.goToProfileView()
                }
                R.id.action_messages -> {
                    presenter.goToMessages()
                }
                R.id.action_news -> {
                    presenter.goToNews()
                }
            }
            true
        }
    }
}