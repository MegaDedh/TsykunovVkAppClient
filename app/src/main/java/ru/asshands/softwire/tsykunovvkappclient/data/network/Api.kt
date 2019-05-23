package ru.asshands.softwire.tsykunovvkappclient.data.network

import io.reactivex.Single
import retrofit2.http.POST
import ru.asshands.softwire.tsykunovvkappclient.data.response.ProfileResponse

interface Api {

    @POST("login")
    fun login(name: String, password: String): Single<ProfileResponse>

}