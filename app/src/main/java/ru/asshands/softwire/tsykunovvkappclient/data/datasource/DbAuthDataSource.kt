package ru.asshands.softwire.tsykunovvkappclient.data.datasource

import io.reactivex.Maybe
import io.reactivex.Single
import ru.asshands.softwire.tsykunovvkappclient.data.database.dao.UserDao
import ru.asshands.softwire.tsykunovvkappclient.data.database.entity.UserEntity
import javax.inject.Inject

interface DbAuthDataSource {

    fun login(phone: String, password: String): Single<UserEntity>
}

class DbAuthDataSourceImpl @Inject constructor(private val userDao: UserDao) : DbAuthDataSource {

    override fun login(phone: String, password: String): Single<UserEntity> =
        userDao.get(phone)
            .flatMap {
                if (it.password == password) {
                    Maybe.just(it)
                } else {
                    Maybe.error(RuntimeException("Неверный логин или пароль"))
                }
            }.toSingle()

}