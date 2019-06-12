package ru.asshands.softwire.tsykunovvkappclient.presentation.entity

class ProfileMessage(
    id: Long,
    val phone: String,
    val firstName: String,
    val lastName: String,
    val birthday: String,
    val city: String,
    val avatar: String

) : BaseMessage(id)