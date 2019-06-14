package ru.asshands.softwire.tsykunovvkappclient.dagger.module.data

import android.content.Context
import android.content.SharedPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import ru.asshands.softwire.tsykunovvkappclient.App
import ru.asshands.softwire.tsykunovvkappclient.data.datasource.*
import ru.asshands.softwire.tsykunovvkappclient.data.repository.*
import ru.asshands.softwire.tsykunovvkappclient.data.storage.StorageInflate
import ru.asshands.softwire.tsykunovvkappclient.data.storage.StorageInflateImpl
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.*
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
    abstract fun bindDbProfileDataSource(instance: DbProfileDataSourceImpl): DbProfileDataSource

    @Singleton
    @Binds
    abstract fun bindDbPostsDataSource(instance: DbPostsDataSourceImpl): DbPostsDataSource

    @Singleton
    @Binds
    abstract fun bindUserDataSource(instance: UserDataSourceImpl): UserDataSource

    @Singleton
    @Binds
    abstract fun bindPostRoomDataSource(instance: PostRoomDataSourceImpl): PostRoomDataSource

    @Singleton
    @Binds
    abstract fun bindUserRepositoryImpl(instance: UserRepositoryImpl): UserRepository

    @Singleton
    @Binds
    abstract fun bindPostRoomRepository(instance: PostRoomRepositoryImpl): PostRoomRepository

    @Singleton
    @Binds
    abstract fun bindStorageInflate(instance: StorageInflateImpl): StorageInflate
}