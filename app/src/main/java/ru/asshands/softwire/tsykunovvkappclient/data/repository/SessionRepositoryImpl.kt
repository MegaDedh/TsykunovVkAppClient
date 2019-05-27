package ru.asshands.softwire.tsykunovvkappclient.data.repository

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.asshands.softwire.tsykunovvkappclient.data.converter.Converter
import ru.asshands.softwire.tsykunovvkappclient.data.datasource.AuthDataSource
import ru.asshands.softwire.tsykunovvkappclient.data.datasource.SessionDataSource
import ru.asshands.softwire.tsykunovvkappclient.data.network.Api
import ru.asshands.softwire.tsykunovvkappclient.data.response.ProfileResponse
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.SessionRepository
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource,
    private val sessionDataSource: SessionDataSource,
    private val userConverter: Converter<ProfileResponse, User>
) : SessionRepository {

    override fun login(name: String, password: String): Single<User> = authDataSource
        .login(name, password)
        .subscribeOn(Schedulers.io())
        .map(userConverter::convert)

    override fun isAuth(): Boolean = sessionDataSource.getToken().isNotEmpty()

}