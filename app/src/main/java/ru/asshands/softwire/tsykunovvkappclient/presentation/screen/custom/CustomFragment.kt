package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.custom

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.custom_view.*
import ru.asshands.softwire.tsykunovvkappclient.R
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BaseFragment
import timber.log.Timber
import javax.inject.Inject

class CustomFragment : BaseFragment(R.layout.custom_view), CustomView {

    @Inject
    @InjectPresenter
    lateinit var presenter: CustomPresenter

    @ProvidePresenter
    fun providePresenter(): CustomPresenter = presenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginAvatarPicker1.setOnIconClickListener {
            Timber.d("loginAvatarPicker1")
            context?.let { Toast.makeText(it, "loginAvatarPicker1", Toast.LENGTH_SHORT).show() }
        }

        loginAvatarPicker2.setOnIconClickListener {
            Timber.d("loginAvatarPicker2")
            context?.let { Toast.makeText(it, "loginAvatarPicker2", Toast.LENGTH_SHORT).show() }
        }

        loginAvatarPicker3.setOnIconClickListener {
            Timber.d("loginAvatarPicker3")
            context?.let { Toast.makeText(it, "loginAvatarPicker3", Toast.LENGTH_SHORT).show() }
        }
    }
}
