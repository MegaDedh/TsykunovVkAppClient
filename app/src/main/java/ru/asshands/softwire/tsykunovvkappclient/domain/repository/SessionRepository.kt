package ru.asshands.softwire.tsykunovvkappclient.domain.repository

import io.reactivex.Single
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User

interface SessionRepository {

    fun login(name: String, password: String): Single<User>
    fun isAuth(): Boolean

}