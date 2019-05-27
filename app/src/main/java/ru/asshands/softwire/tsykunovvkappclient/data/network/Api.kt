package ru.asshands.softwire.tsykunovvkappclient.data.network

import io.reactivex.Single
import retrofit2.http.*
import ru.asshands.softwire.tsykunovvkappclient.data.response.PostResponse
import ru.asshands.softwire.tsykunovvkappclient.data.response.ProfileResponse

interface Api {

    @POST("login")

    fun login(name: String, password: String): Single<ProfileResponse>

    @GET("posts")
    fun getPosts(): Single<List<PostResponse>>

}
