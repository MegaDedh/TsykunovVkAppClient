package ru.asshands.softwire.tsykunovvkappclient.domain.entity

data class User (
    val id: Long,
    val firstName: String,
    val lastName: String,
    val status: String,
    val avatar: String,
    val birthday: String,
    val city: String,
    val phone: String)