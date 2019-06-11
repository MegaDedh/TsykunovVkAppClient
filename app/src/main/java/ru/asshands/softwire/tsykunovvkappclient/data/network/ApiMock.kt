
package ru.asshands.softwire.tsykunovvkappclient.data.network

import io.reactivex.Single
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.PostResponse
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.UserResponse
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ApiMock @Inject constructor() : Api {


    override fun login(name: String, password: String): Single<UserResponse> =
        if (name == "root" && password == "root") {
            val profile = UserResponse(
                100200300,
                "Alexey",
                "Tsykunov",
                "MyStatus",
                "https://pp.userapi.com/c850016/v850016044/1a25fc/cHZ5EmlnW5o.jpg",
                "21.05.1988",
                "21.05.1988",
                "+79627775069"
            )
            Single.just(profile)

        } else {
            Single.error(RuntimeException("User not found"))
        }
            .delay(2, TimeUnit.SECONDS)


    override fun getPosts(page: Int): Single<List<PostResponse>> =
        Single.just(((20 * page - 20 + 1)..(page * 20)).map { PostResponse(it.toLong()) })
            .delay(2, TimeUnit.SECONDS)

    override fun getProfile(userId: Long): Single<UserResponse> {
        val profile = UserResponse(
            100200300,
            "+79627777777",
            "Alexey_Mock",
            "Tsykunov_Mock",
            "MyMockStatus",
            "https://pp.userapi.com/c850016/v850016044/1a25fc/cHZ5EmlnW5o.jpg",
            "21.05.1988",
            "Tomsk"
        )
        return Single.just(profile)

    }
}