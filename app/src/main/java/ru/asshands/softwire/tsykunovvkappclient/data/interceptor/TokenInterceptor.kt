package ru.asshands.softwire.tsykunovvkappclient.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response
import ru.asshands.softwire.tsykunovvkappclient.data.datasource.SessionDataSource
import javax.inject.Inject

class TokenInterceptor @Inject constructor(
    private val sessionDataSource: SessionDataSource
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val token = sessionDataSource.getToken()

        return if (token.isEmpty()) {
            chain.proceed(chain.request())
        } else {
            val request = chain
                .request()
                .newBuilder()
                .addHeader("Authorization:", token).build()

            chain.proceed(request)
        }
    }
}