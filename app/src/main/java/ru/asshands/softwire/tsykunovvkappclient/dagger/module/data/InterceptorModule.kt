package ru.asshands.softwire.tsykunovvkappclient.dagger.module.data

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor
import ru.asshands.softwire.tsykunovvkappclient.data.datasource.SessionDataSource
import ru.asshands.softwire.tsykunovvkappclient.data.interceptor.MockInterceptor
import ru.asshands.softwire.tsykunovvkappclient.data.interceptor.TokenInterceptor
import timber.log.Timber
import javax.inject.Singleton

@Module
class InterceptorModule {

    @Singleton
    @Provides
    fun provideTokenInterceptor(sessionDataSource: SessionDataSource): TokenInterceptor =
        TokenInterceptor(sessionDataSource)

    @Singleton
    @Provides
    fun provideMockInterceptor(gson: Gson): MockInterceptor = MockInterceptor(gson)

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor { Timber.tag("OkHttp").d(it) }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
}