package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.addpost

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_add_post.*
import kotlinx.android.synthetic.main.item_profile_message.*
import ru.asshands.softwire.tsykunovvkappclient.R
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.BaseFragment
import javax.inject.Inject

class AddPostFragment  : BaseFragment(R.layout.fragment_add_post),
    AddPostView  {

    @Inject
    @InjectPresenter
    lateinit var presenter: AddPostPresenter

    @ProvidePresenter
    fun providePresenter(): AddPostPresenter = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAddPostButton()
        initCancelButton()
        initAddPostPicButton()
    }

    private fun initAddPostPicButton() {
        addPostPicImageView.setOnClickListener {
            addPostTextFieldPic.visibility = View.VISIBLE
        }
    }

    private fun initAddPostButton() {
        addPost_btn.setOnClickListener {
            presenter.addPost(
                addPostTextField.text.toString(),
                addPostTextFieldPic.text.toString())
        }
    }

    private fun initCancelButton() {
        addPost_cancel_btn.setOnClickListener {
            presenter.goToProfileViewScreen()
        }
    }

    override fun postAddedSuccessful() {
       // context?.let { Toast.makeText(it, R.string.edit_profile_success, Toast.LENGTH_LONG).show() }
        presenter.goToProfileViewScreen()
    }

    override fun postNotAdded() {
        context?.let { Toast.makeText(it, R.string.add_post_failure, Toast.LENGTH_LONG).show() }
    }
}