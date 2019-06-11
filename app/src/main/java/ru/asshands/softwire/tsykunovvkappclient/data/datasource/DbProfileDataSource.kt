package ru.asshands.softwire.tsykunovvkappclient.data.datasource

import io.reactivex.Maybe
import io.reactivex.Single
import ru.asshands.softwire.tsykunovvkappclient.data.database.dao.UserDao
import ru.asshands.softwire.tsykunovvkappclient.data.database.entity.UserEntity
import javax.inject.Inject


interface DbProfileDataSource {

    fun getProfile(id: Long): Single<UserEntity>
}

class DbProfileDataSourceImpl @Inject constructor(private val userDao: UserDao) : DbProfileDataSource {

    override fun getProfile(id: Long): Single<UserEntity> =
        userDao.getProfile(id)
            .flatMap {Maybe.just(it)
            }.toSingle()
}