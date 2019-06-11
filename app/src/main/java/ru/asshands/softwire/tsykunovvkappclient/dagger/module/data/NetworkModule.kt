package ru.asshands.softwire.tsykunovvkappclient.dagger.module.data

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.asshands.softwire.tsykunovvkappclient.dagger.LiveQualifier
import ru.asshands.softwire.tsykunovvkappclient.dagger.MockQualifier
import ru.asshands.softwire.tsykunovvkappclient.data.interceptor.MockInterceptor
import ru.asshands.softwire.tsykunovvkappclient.data.interceptor.TokenInterceptor
import ru.asshands.softwire.tsykunovvkappclient.data.network.Api
import ru.asshands.softwire.tsykunovvkappclient.data.network.ApiMock
import timber.log.Timber
import javax.inject.Singleton

@Module(includes = [InterceptorModule::class])
abstract class NetworkModule {

    @Module
    companion object {

        @JvmStatic
        @Singleton
        @Provides
        fun provideGson(): Gson = GsonBuilder()
            .setDateFormat("yyyy.MM.dd")
            .create()

        @JvmStatic
        @Singleton
        @Provides
        fun provideOkHttp(
            tokenInterceptor: TokenInterceptor,
            mockInterceptor: MockInterceptor,
            httpLoggingInterceptor: HttpLoggingInterceptor
        ): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(mockInterceptor)
            .addInterceptor(tokenInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()

        @JvmStatic
        @Singleton
        @Provides
        fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl("https://google.com")
            .client(okHttpClient)
            .build()

        @JvmStatic
        @Singleton
        @Provides
        fun provideApi(retrofit: Retrofit) = retrofit.create(Api::class.java)
    }

    @Singleton
    @Binds
    @MockQualifier
    abstract fun bindMockApi(instance: ApiMock): Api
}