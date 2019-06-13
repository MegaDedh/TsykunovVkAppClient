package ru.asshands.softwire.tsykunovvkappclient.presentation.entity

class PostMessage(
    id: Long,
    val message: String,
    val contentType: String,
    val contentUrl: String,
    val likes: Int
) : BaseMessage(id)