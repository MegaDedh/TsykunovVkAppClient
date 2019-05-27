package ru.asshands.softwire.tsykunovvkappclient.data.network

import io.reactivex.Single
import ru.asshands.softwire.tsykunovvkappclient.data.response.PostResponse
import ru.asshands.softwire.tsykunovvkappclient.data.response.ProfileResponse
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ApiMock @Inject constructor() : Api {

    override fun login(name: String, password: String): Single<ProfileResponse> =
        if (name == "root" && password == "root") {
            val profile = ProfileResponse(1, "root", "rootovich")
            Single.just(profile)
        } else {
            Single.error(RuntimeException("User not found"))
        }
            .delay(2, TimeUnit.SECONDS)


    override fun getPosts(page: Int): Single<List<PostResponse>> =
        Single.just(((20 * page - 20 + 1)..(page * 20)).map { PostResponse(it.toLong()) })
            .delay(2, TimeUnit.SECONDS)

}