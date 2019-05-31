package ru.asshands.softwire.tsykunovvkappclient.data.network

import io.reactivex.Single
import retrofit2.http.*
import ru.asshands.softwire.tsykunovvkappclient.data.network.request.UserRequest
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.BaseResponse
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.LoginResponse
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.PostResponse
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.UserResponse

interface Api {

    @POST("login")
    fun login(@Body userRequest: UserRequest): Single<BaseResponse<LoginResponse>>

    @GET("posts/page/{page}")
    fun getPosts(@Path("page") page: Int): Single<BaseResponse<List<PostResponse>>>

    @GET("{user_id}/profile")
    fun getProfile(@Path("user_id") userId: Long): Single<UserResponse>

}
