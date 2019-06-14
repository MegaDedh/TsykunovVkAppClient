package ru.asshands.softwire.tsykunovvkappclient.data.repository

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.asshands.softwire.tsykunovvkappclient.data.datasource.PostRoomDataSource
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.Post
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.PostRoomRepository
import javax.inject.Inject


class PostRoomRepositoryImpl @Inject constructor(
    private val postRoomDataSource: PostRoomDataSource) : PostRoomRepository {

    override fun create(post: Post): Single<Long> = postRoomDataSource
        .create(post)
        .subscribeOn(Schedulers.io())

    override fun update(post: Post): Single<Int> = postRoomDataSource
        .update(post)
        .subscribeOn(Schedulers.io())

}

