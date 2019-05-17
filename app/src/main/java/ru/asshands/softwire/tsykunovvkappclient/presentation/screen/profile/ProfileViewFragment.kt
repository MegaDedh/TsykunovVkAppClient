package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.asshands.softwire.tsykunovvkappclient.App
import ru.asshands.softwire.tsykunovvkappclient.R
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BaseFragment
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Screen
import kotlinx.android.synthetic.main.fragment_profile_view.*
import org.koin.core.KoinComponent
import org.koin.core.get
import org.koin.core.inject
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.login.LoginPresenter
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.feed.BaseMessage
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.feed.FeedAdapter
import ru.terrakok.cicerone.Router

class ProfileViewFragment (profileId: String): BaseFragment(R.layout.fragment_profile_view),
    ProfileView, KoinComponent {

    @InjectPresenter
    lateinit var presenter: ProfileViewPresenter

    private val feedAdapter = FeedAdapter()

    @ProvidePresenter
    fun providePresenter(): ProfileViewPresenter = get()

    private val router by inject<Router>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initFeed()
    }

    private fun initFeed() {
        profileViewFeed.isNestedScrollingEnabled = false
        profileViewFeed.layoutManager = LinearLayoutManager(context)
        profileViewFeed.adapter = feedAdapter
    }

    private fun initToolbar() {
        profileViewToolbar.inflateMenu(R.menu.menu_profile_view)
        profileViewToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_profile_edit -> {
                    router.replaceScreen(Screen.ProfileViewEditScreen())
                }
                R.id.action_logout -> presenter.logout()
            }
            true
        }
    }

    override fun showProfile(firstName: String, surname: String, birthday: String, city: String) {
        profileViewFirstName.text = firstName
        profileViewSurname.text = surname
        profileViewBirthday.text = birthday
        profileViewCity.text = city
    }

    override fun showFeed(items: List<BaseMessage>) {
        feedAdapter.setItems(items)
    }

    override fun goToLoginScreen() {
        router.replaceScreen(Screen.LoginScreen())
    }
}