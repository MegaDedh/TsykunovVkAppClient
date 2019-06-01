package ru.asshands.softwire.tsykunovvkappclient.data.repository

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.asshands.softwire.tsykunovvkappclient.data.datasource.UserDataSource
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userDataSource: UserDataSource) : UserRepository {

    override fun create(user: User, password: String): Single<Long> = userDataSource
        .create(user, password)
        .subscribeOn(Schedulers.io())

}