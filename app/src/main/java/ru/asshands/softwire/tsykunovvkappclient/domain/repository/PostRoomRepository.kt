package ru.asshands.softwire.tsykunovvkappclient.domain.repository

import io.reactivex.Single
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.Post

interface PostRoomRepository {

    fun create(post: Post): Single<Long>
    fun update(post: Post): Single<Int>
}