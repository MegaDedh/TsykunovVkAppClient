package ru.asshands.softwire.tsykunovvkappclient.data.repository

import ru.asshands.softwire.tsykunovvkappclient.domain.repository.SessionRepository
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor() : SessionRepository {

    override fun isAuth(): Boolean = true

}