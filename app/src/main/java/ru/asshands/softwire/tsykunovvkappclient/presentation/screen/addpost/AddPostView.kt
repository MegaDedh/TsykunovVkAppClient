package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.addpost

import com.arellomobile.mvp.MvpView

interface AddPostView : MvpView{
    fun postAddedSuccessful()
    fun postNotAdded()
}