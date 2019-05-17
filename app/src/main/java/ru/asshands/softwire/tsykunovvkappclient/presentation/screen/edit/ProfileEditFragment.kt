package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.edit

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.asshands.softwire.tsykunovvkappclient.App
import ru.asshands.softwire.tsykunovvkappclient.R
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.ProfileData
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BaseFragment
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Screen
import kotlinx.android.synthetic.main.fragment_profile_edit.*
import org.koin.core.KoinComponent
import org.koin.core.get
import org.koin.core.inject
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.login.LoginPresenter
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.login.LoginView
import ru.terrakok.cicerone.Router

class ProfileEditFragment : BaseFragment(R.layout.fragment_profile_edit),
    ProfileEditView, KoinComponent {


    @InjectPresenter
    lateinit var presenter: ProfileEditPresenter

    @ProvidePresenter
    fun providePresenter(): ProfileEditPresenter = get()

    private val router by inject<Router>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSaveChangesButton()
        initCancelButton()
    }

    override fun onStart() {
        super.onStart()
        presenter.getProfile()
    }

    private fun initSaveChangesButton() {
        profile_edit_save_btn.setOnClickListener {
            disableUI()
            presenter.saveChanges(
                profileEditFirstNameField.text.toString(),
                profileEditSurnameField.text.toString(),
                profileEditBirthdayField.text.toString(),
                profileEditCityField.text.toString())
        }
    }

    private fun initCancelButton() {
        profile_edit_cancel_btn.setOnClickListener {
            goToProfileViewScreen()
        }
    }

    private fun goToProfileViewScreen(){
        router.replaceScreen(Screen.ProfileViewScreen(ProfileData.ProfileID))
    }

    private fun disableUI(){
        profileEditFirstNameField.isEnabled = false
        profileEditSurnameField.isEnabled = false
        profileEditBirthdayField.isEnabled = false
        profileEditCityField.isEnabled = false
        profile_edit_save_btn.isEnabled = false
        profile_edit_cancel_btn.isEnabled = false
        profile_edit_progressBar.visibility = View.VISIBLE
    }

    private fun enableUI(){
        profileEditFirstNameField.isEnabled = true
        profileEditSurnameField.isEnabled = true
        profileEditBirthdayField.isEnabled = true
        profileEditCityField.isEnabled = true
        profile_edit_save_btn.isEnabled = true
        profile_edit_cancel_btn.isEnabled = true
        profile_edit_progressBar.visibility = View.GONE
    }

    override fun showEditProfile(firstName: String, surname: String, birthday: String, city: String) {
        profileEditFirstNameField.setText(firstName)
        profileEditSurnameField.setText(surname)
        profileEditBirthdayField.setText(birthday)
        profileEditCityField.setText(city)
    }

    override fun profileUpdated() {
        context?.let { Toast.makeText(it, R.string.edit_profile_success, Toast.LENGTH_LONG).show() }
        enableUI()
        goToProfileViewScreen()
}

    override fun profileNotUpdated() {
        context?.let { Toast.makeText(it, R.string.edit_profile_failure, Toast.LENGTH_LONG).show() }
        enableUI()
    }
}