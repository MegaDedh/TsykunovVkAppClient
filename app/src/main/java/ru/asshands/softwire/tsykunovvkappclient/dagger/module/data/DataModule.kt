package ru.asshands.softwire.tsykunovvkappclient.dagger.module.data

import android.content.Context
import android.content.SharedPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import ru.asshands.softwire.tsykunovvkappclient.App
import ru.asshands.softwire.tsykunovvkappclient.data.datasource.*
import ru.asshands.softwire.tsykunovvkappclient.data.repository.PostRepositoryImpl
import ru.asshands.softwire.tsykunovvkappclient.data.repository.ProfileRepositoryImpl
import ru.asshands.softwire.tsykunovvkappclient.data.repository.SessionRepositoryImpl
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.PostRepository
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.ProfileRepository
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.SessionRepository

@Module(
    includes = [
    NetworkModule::class,
    ConverterModule::class
]
)

abstract class DataModule {

    @Module
    companion object {

        @JvmStatic
        @Reusable
        @Provides
        fun provideSharedPreferences(app: App): SharedPreferences =
            app.getSharedPreferences("CommonSharedPreferences", Context.MODE_PRIVATE)
    }

    @Reusable
    @Binds
    abstract fun bindAuthDataSource(instance: AuthDataSourceImpl): AuthDataSource

    @Reusable
    @Binds
    abstract fun bindProfileDataSource(instance: ProfileDataSourceImpl): ProfileDataSource

    @Reusable
    @Binds
    abstract fun bindSessionRepository(instance: SessionRepositoryImpl): SessionRepository

    @Reusable
    @Binds
    abstract fun bindSessionDataSource(instance: SessionDataSourceImpl): SessionDataSource

    @Reusable
    @Binds
    abstract fun bindPostRepository(instance: PostRepositoryImpl): PostRepository

    @Reusable
    @Binds
    abstract fun bindProfileRepository(instance: ProfileRepositoryImpl): ProfileRepository

}