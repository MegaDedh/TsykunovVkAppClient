package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.asshands.softwire.tsykunovvkappclient.App
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BaseFragment
import ru.asshands.softwire.tsykunovvkappclient.presentation.navigation.Screen
import kotlinx.android.synthetic.main.fragment_login.*
import androidx.appcompat.app.AlertDialog
import com.arellomobile.mvp.presenter.ProvidePresenter
import org.koin.core.KoinComponent
import org.koin.core.get
import org.koin.core.inject
import ru.asshands.softwire.tsykunovvkappclient.R
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.splash.SplashPresenter
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router

class LoginFragment : BaseFragment(R.layout.fragment_login),LoginView, KoinComponent {


    @InjectPresenter
    lateinit var presenter: LoginPresenter
    lateinit var forgotPasswordDialog: AlertDialog

    @ProvidePresenter
    fun providePresenter(): LoginPresenter = get()

     private val router by inject<Router>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLoginButton()
        initForgetPasswordButton()
    }

    private fun initLoginButton() {
        login_enter_btn.setOnClickListener {
            presenter.login(login_account.text.toString(), login_password.text.toString())

        }
    }

    private fun initForgetPasswordButton() {
        login_forgot_password_btn.setOnClickListener {
            presenter.onClickForgotPasswordBtn(it.context)
        }
    }

    override fun accessAllowed(profileId: String) {
     //   App.INSTANCE.router.replaceScreen(Screen.ProfileViewScreen(profileId))
        router.replaceScreen(Screen.ProfileViewScreen(profileId))
    }

    override fun accessDenied() {
        context?.let { Toast.makeText(it, "В доступе отказано", Toast.LENGTH_SHORT).show() }
    }

    override fun showForgotPasswordDialog(title: String, message: String) {
        context?.let {
            forgotPasswordDialog = AlertDialog.Builder(it)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton("Okay") { _, _ -> }
                .show()
        }
    }
}