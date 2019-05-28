package ru.asshands.softwire.tsykunovvkappclient.data.datasource

import io.reactivex.Single
import ru.asshands.softwire.tsykunovvkappclient.dagger.MockQualifier
import ru.asshands.softwire.tsykunovvkappclient.data.network.Api
import ru.asshands.softwire.tsykunovvkappclient.data.response.ProfileResponse
import javax.inject.Inject

interface ProfileDataSource {

    fun getProfile(): Single<ProfileResponse>

}

class ProfileDataSourceImpl @Inject constructor(@MockQualifier private val api: Api) : ProfileDataSource {

    override fun getProfile(): Single<ProfileResponse> =
        api.getProfile(100200300)
}