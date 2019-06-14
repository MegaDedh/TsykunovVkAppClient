package ru.asshands.softwire.tsykunovvkappclient.dagger.module.data

import dagger.Module
import dagger.Provides
import ru.asshands.softwire.tsykunovvkappclient.App
import ru.asshands.softwire.tsykunovvkappclient.data.database.AppDatabase
import ru.asshands.softwire.tsykunovvkappclient.data.database.dao.PostDao
import ru.asshands.softwire.tsykunovvkappclient.data.database.dao.UserDao
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(app: App): AppDatabase = AppDatabase.create(app, true)

    @Singleton
    @Provides
    fun provideUserDao(db: AppDatabase): UserDao = db.getUserDao()

    @Singleton
    @Provides
    fun providePostDao(db: AppDatabase): PostDao = db.getPostDao()
}