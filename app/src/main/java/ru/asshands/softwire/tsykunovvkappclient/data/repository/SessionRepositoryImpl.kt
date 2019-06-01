package ru.asshands.softwire.tsykunovvkappclient.data.repository

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.asshands.softwire.tsykunovvkappclient.data.converter.Converter
import ru.asshands.softwire.tsykunovvkappclient.data.database.entity.UserEntity
import ru.asshands.softwire.tsykunovvkappclient.data.datasource.AuthDataSource
import ru.asshands.softwire.tsykunovvkappclient.data.datasource.DbAuthDataSource
import ru.asshands.softwire.tsykunovvkappclient.data.datasource.SessionDataSource
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.LoginResponse
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.UserResponse
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.SessionRepository
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource,
    private val dbAuthDataSource: DbAuthDataSource,
    private val sessionDataSource: SessionDataSource,
    private val userEntityConverter: Converter<UserEntity, User>
) : SessionRepository {

    override fun login(name: String, password: String): Single<User> = dbAuthDataSource
        .login(name, password)
        .subscribeOn(Schedulers.io())
        .map(userEntityConverter::convert)

    override fun logout() = sessionDataSource.clearToken()

    override fun saveToken(token: String) = sessionDataSource.saveToken(token)

    override fun getToken(): String = sessionDataSource.getToken()

    override fun isAuth(): Boolean = sessionDataSource.getToken().isNotEmpty()

}