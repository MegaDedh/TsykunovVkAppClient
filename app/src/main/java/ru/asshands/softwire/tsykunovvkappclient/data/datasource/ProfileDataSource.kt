package ru.asshands.softwire.tsykunovvkappclient.data.datasource

import io.reactivex.Single
import ru.asshands.softwire.tsykunovvkappclient.dagger.MockQualifier
import ru.asshands.softwire.tsykunovvkappclient.data.network.Api
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.UserResponse
import javax.inject.Inject

interface ProfileDataSource {

    fun getProfile(): Single<UserResponse>

}

class ProfileDataSourceImpl @Inject constructor(private val api: Api) : ProfileDataSource {

    override fun getProfile(): Single<UserResponse> =
        api.getProfile(100200300)
}