package ru.asshands.softwire.tsykunovvkappclient.data.datasource

import io.reactivex.Single
import ru.asshands.softwire.tsykunovvkappclient.dagger.MockQualifier
import ru.asshands.softwire.tsykunovvkappclient.data.converter.BaseResponseTransformer
import ru.asshands.softwire.tsykunovvkappclient.data.network.Api
import ru.asshands.softwire.tsykunovvkappclient.data.network.request.UserRequest
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.LoginResponse
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.UserResponse
import javax.inject.Inject

interface AuthDataSource {

    fun login(name: String, password: String): Single<LoginResponse>
}

class AuthDataSourceImpl @Inject constructor(private val api: Api) : AuthDataSource {

    override fun login(name: String, password: String): Single<LoginResponse> =
        api
            .login(UserRequest(name, password))
            .compose(BaseResponseTransformer())
}