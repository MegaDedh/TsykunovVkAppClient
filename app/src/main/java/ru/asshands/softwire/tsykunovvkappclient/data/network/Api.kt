package ru.asshands.softwire.tsykunovvkappclient.data.network

import io.reactivex.Single
import retrofit2.http.*
import ru.asshands.softwire.tsykunovvkappclient.data.response.PostResponse
import ru.asshands.softwire.tsykunovvkappclient.data.response.ProfileResponse

interface Api {

    @FormUrlEncoded
    @POST("login")
    fun login(@Field("name") name: String, @Field("password") password: String):
            Single<ProfileResponse>

    @GET("posts/page/{page}")
    fun getPosts(@Path("page") page: Int): Single<List<PostResponse>>

}
