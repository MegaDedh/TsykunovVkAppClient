package ru.asshands.softwire.tsykunovvkappclient.data.datasource

import io.reactivex.Maybe
import io.reactivex.Single
import ru.asshands.softwire.tsykunovvkappclient.data.database.dao.PostDao
import ru.asshands.softwire.tsykunovvkappclient.data.database.dao.UserDao
import ru.asshands.softwire.tsykunovvkappclient.data.database.entity.PostEntity
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.Post
import javax.inject.Inject

interface DbPostsDataSource{

 //   fun getPosts(page: Int): Single<List<PostEntity>>
    fun get(id: Long): Single<PostEntity>

}

class DbPostsDataSourceImpl @Inject constructor(private val postDao: PostDao) : DbPostsDataSource{
    override fun get(id: Long): Single<PostEntity> =
        postDao.get(id)
            .flatMap {
                Maybe.just(it)
            }.toSingle()

}