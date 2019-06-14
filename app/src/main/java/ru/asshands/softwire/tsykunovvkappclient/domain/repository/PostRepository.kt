package ru.asshands.softwire.tsykunovvkappclient.domain.repository

import io.reactivex.Single
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.PostResponse
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.Post

interface PostRepository {

    fun getPosts(page: Int): Single<List<Post>>


    fun getPost(id: Long): Post
    fun getPostDb(id: Long): Single<Post>
}
