package ru.asshands.softwire.tsykunovvkappclient.data.network

import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import ru.asshands.softwire.tsykunovvkappclient.data.response.ProfileResponse

interface Api {

    @POST("login/{pass}")

  //  fun login(@Query ("name") name: String, @Query ("password")password: String): Single<ProfileResponse>
    fun login(@Body name: String, @Path("pass") password: String): Single<ProfileResponse>

}
