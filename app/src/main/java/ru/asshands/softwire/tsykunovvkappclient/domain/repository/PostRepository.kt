package ru.asshands.softwire.tsykunovvkappclient.domain.repository

import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.feed.BaseMessage

interface PostRepository {

    fun getAll(): List<BaseMessage>

    fun getPost(id: Long): BaseMessage
}