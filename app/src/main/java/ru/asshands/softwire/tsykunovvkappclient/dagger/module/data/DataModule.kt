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
import ru.asshands.softwire.tsykunovvkappclient.data.repository.UserRepositoryImpl
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.PostRepository
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.ProfileRepository
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.SessionRepository
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.UserRepository
import javax.inject.Singleton

@Module(
    includes = [
    NetworkModule::class,
    ConverterModule::class,
    DatabaseModule::class
]
)

abstract class DataModule {

    @Module
    companion object {

        @JvmStatic
        @Singleton
        @Provides
        fun provideSharedPreferences(app: App): SharedPreferences =
            app.getSharedPreferences("CommonSharedPreferences", Context.MODE_PRIVATE)
    }

    @Singleton
    @Binds
    abstract fun bindAuthDataSource(instance: AuthDataSourceImpl): AuthDataSource

    @Singleton
    @Binds
    abstract fun bindProfileDataSource(instance: ProfileDataSourceImpl): ProfileDataSource

    @Singleton
    @Binds
    abstract fun bindSessionRepository(instance: SessionRepositoryImpl): SessionRepository

    @Singleton
    @Binds
    abstract fun bindSessionDataSource(instance: SessionDataSourceImpl): SessionDataSource

    @Singleton
    @Binds
    abstract fun bindPostRepository(instance: PostRepositoryImpl): PostRepository

    @Singleton
    @Binds
    abstract fun bindProfileRepository(instance: ProfileRepositoryImpl): ProfileRepository

    @Singleton
    @Binds
    abstract fun bindDbAuthDataSource(instance: DbAuthDataSourceImpl): DbAuthDataSource

    @Singleton
    @Binds
    abstract fun bindUserDataSource(instance: UserDataSourceImpl): UserDataSource

    @Singleton
    @Binds
    abstract fun bindUserRepositoryImpl(instance: UserRepositoryImpl): UserRepository
}