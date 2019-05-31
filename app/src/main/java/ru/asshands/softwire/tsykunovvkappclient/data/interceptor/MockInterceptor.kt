package ru.asshands.softwire.tsykunovvkappclient.data.interceptor

import com.google.gson.Gson
import okhttp3.*
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.BaseResponse
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.ErrorResponse
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.LoginResponse
import java.util.*

class MockInterceptor(private val gson: Gson) : Interceptor {

    companion object {
        const val SUCCESS_CODE = 200
        const val NOT_FOUND_CODE = 404
        const val POST = "POST"
        const val GET = "GET"
    }

    private val random = Random()

    override fun intercept(chain: Interceptor.Chain): Response {
        val uri = chain.request().url().uri().toString()

        val responseString = when {
            uri.endsWith("login") && chain.request().method() == POST -> getLoginResponse()
            uri.contains("posts/page/") && chain.request().method() == GET -> getPosts(uri.split("/").last().toInt())
            else -> throw RuntimeException()
        }

        Thread.sleep((1 + random.nextInt(2)) * 1000L)

        return chain.proceed(chain.request())
            .newBuilder()
            .code(SUCCESS_CODE)
            .protocol(Protocol.HTTP_2)
            .message(responseString)
            .body(
                ResponseBody.create(
                    MediaType.parse("application/json"),
                    responseString.toByteArray()
                )
            )
            .addHeader("content-type", "application/json")
            .build()
    }

    private fun getLoginResponse(): String = gson.toJson(
        BaseResponse(LoginResponse(UUID.randomUUID().toString()), null)
    )

    private fun getPosts(page: Int): String = ""

    private fun getError(code: Int, message: String) = gson.toJson(
        BaseResponse<Any>(null, ErrorResponse(code, message))
    )
}