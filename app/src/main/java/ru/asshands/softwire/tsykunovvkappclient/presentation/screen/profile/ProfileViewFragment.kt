package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.asshands.softwire.tsykunovvkappclient.R
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_profile_view.*
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.ProfileData
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.feed.BaseMessage
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.feed.FeedAdapter
import javax.inject.Inject


class ProfileViewFragment: BaseFragment(R.layout.fragment_profile_view),
    ProfileView {

    @Inject
    @InjectPresenter
    lateinit var presenter: ProfileViewPresenter

    private val feedAdapter = FeedAdapter()

    @ProvidePresenter
    fun providePresenter(): ProfileViewPresenter = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initFeed()
    }

    override fun onStart() {
        super.onStart()
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
                R.id.action_profile_edit -> presenter.goToEditProfile()
                R.id.action_logout -> presenter.logout()
            }
            true
        }
    }

  //  override fun showProfile(firstName: String, surname: String, birthday: String, city: String) {
    override fun showProfile(data: ProfileData) {
        profileViewFirstName.text = data.firstName
        profileViewSurname.text = data.surname
        profileViewBirthday.text = data.birthday
        profileViewCity.text = data.city
    }

    override fun showFeed(items: List<BaseMessage>) {
        feedAdapter.setItems(items)
    }

}