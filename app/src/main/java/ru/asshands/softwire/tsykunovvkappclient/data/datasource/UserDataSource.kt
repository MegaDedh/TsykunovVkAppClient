package ru.asshands.softwire.tsykunovvkappclient.data.datasource

import io.reactivex.Single
import ru.asshands.softwire.tsykunovvkappclient.data.database.dao.UserDao
import ru.asshands.softwire.tsykunovvkappclient.data.database.entity.UserEntity
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import javax.inject.Inject

interface UserDataSource {

    fun create(user: User, password: String): Single<Long>
}

class UserDataSourceImpl @Inject constructor(private val userDao: UserDao) : UserDataSource {

    override fun create(user: User, password: String): Single<Long> = Single.fromCallable {
        userDao.insert(
            UserEntity(
                user.id,
                user.phone,
                password,
                user.firstName,
                user.lastName,
                user.avatar
            )
        )
    }

}