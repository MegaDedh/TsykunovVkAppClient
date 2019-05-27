package ru.asshands.softwire.tsykunovvkappclient.domain.repository

import io.reactivex.Single
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.Post

interface PostRepository {

    fun getPosts(): Single<List<Post>>

    fun getPost(id: Long): Post
}