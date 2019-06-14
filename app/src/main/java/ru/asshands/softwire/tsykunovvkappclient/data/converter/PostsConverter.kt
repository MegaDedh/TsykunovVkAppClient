package ru.asshands.softwire.tsykunovvkappclient.data.converter

import ru.asshands.softwire.tsykunovvkappclient.data.database.entity.PostEntity
import ru.asshands.softwire.tsykunovvkappclient.data.database.entity.UserEntity
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.PostResponse
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.Post
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import javax.inject.Inject

class PostsConverter @Inject constructor() : Converter<@JvmSuppressWildcards List<@JvmSuppressWildcards PostResponse>, @JvmSuppressWildcards List<@JvmSuppressWildcards Post>> {

    override fun convert(t: List<PostResponse>): List<Post> = t.map {
        Post(
            it.id,
            it.message,
            it.contentType,
            it.contentUrl,
            it.likes
        )
    }
}

class PostEntityConverter @Inject constructor() : Converter<PostEntity, Post> {

    override fun convert(t: PostEntity): Post = Post(
        t.id,
        t.message,
        t.contentType,
        t.contentUrl,
        t.likes
    )
}