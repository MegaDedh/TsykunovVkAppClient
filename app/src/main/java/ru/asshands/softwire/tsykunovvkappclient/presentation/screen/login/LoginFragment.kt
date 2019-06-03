package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.*
import androidx.appcompat.app.AlertDialog
import com.arellomobile.mvp.presenter.ProvidePresenter
import ru.asshands.softwire.tsykunovvkappclient.R
import timber.log.Timber
import javax.inject.Inject

class LoginFragment : BaseFragment(R.layout.fragment_login),LoginView {

    @Inject
    @InjectPresenter
    lateinit var presenter: LoginPresenter
    private lateinit var forgotPasswordDialog: AlertDialog

    @ProvidePresenter
    fun providePresenter(): LoginPresenter = presenter

    /*   override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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
    }*/
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


        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            loginAvatarPicker1.setOnIconClickListener {
                Timber.d("loginAvatarPicker1")
            }

            loginAvatarPicker2.setOnIconClickListener {
                Timber.d("loginAvatarPicker2")
            }

            loginAvatarPicker3.setOnIconClickListener {
                Timber.d("loginAvatarPicker3")
            }
        }
    }
