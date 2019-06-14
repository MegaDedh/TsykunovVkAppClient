package ru.asshands.softwire.tsykunovvkappclient.data.datasource

import io.reactivex.Single
import ru.asshands.softwire.tsykunovvkappclient.data.database.dao.PostDao
import ru.asshands.softwire.tsykunovvkappclient.data.database.entity.PostEntity
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.Post
import javax.inject.Inject

interface PostRoomDataSource {

    fun create(post: Post): Single<Long>
    fun update(post: Post): Single<Int>
}

class PostRoomDataSourceImpl @Inject constructor(private val postDao: PostDao) : PostRoomDataSource {

    override fun create(post: Post): Single<Long> = Single.fromCallable {
        postDao.insert(
            PostEntity(
                post.id,
                post.message,
                post.contentType,
                post.contentUrl,
                post.likes
            )
        )
    }

    override fun update(post: Post): Single<Int> = Single.fromCallable {
        postDao.update(
            PostEntity(
                post.id,
                post.message,
                post.contentType,
                post.contentUrl,
                post.likes
            )
        )
    }
}