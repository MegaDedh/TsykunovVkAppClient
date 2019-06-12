package ru.asshands.softwire.tsykunovvkappclient.presentation.entity

class PostMessage(
    id: Long,
    val message: String,
    val image: String
) : BaseMessage(id)