package ru.asshands.softwire.tsykunovvkappclient.domain.entity

import java.util.*

data class User (
    val id: Long,
    val phone: String,
    val firstName: String,
    val lastName: String,
    val birthday: String,
    val city: String,
    val avatar: String
)