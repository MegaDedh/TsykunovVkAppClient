package ru.asshands.softwire.tsykunovvkappclient.domain.entity

class Post(
    val id: Long,
    val message: String,
    val contentType: String,
    val contentUrl: String,
    val likes: Int
)