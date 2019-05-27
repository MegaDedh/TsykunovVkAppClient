package ru.asshands.softwire.tsykunovvkappclient.data.datasource

import io.reactivex.Single
import ru.asshands.softwire.tsykunovvkappclient.dagger.MockQualifier
import ru.asshands.softwire.tsykunovvkappclient.data.network.Api
import ru.asshands.softwire.tsykunovvkappclient.data.response.ProfileResponse
import javax.inject.Inject

interface AuthDataSource {

    fun login(name: String, password: String): Single<ProfileResponse>
}

class AuthDataSourceImpl @Inject constructor(@MockQualifier private val api: Api) : AuthDataSource {

    override fun login(name: String, password: String): Single<ProfileResponse> = api.login(name, password)
}