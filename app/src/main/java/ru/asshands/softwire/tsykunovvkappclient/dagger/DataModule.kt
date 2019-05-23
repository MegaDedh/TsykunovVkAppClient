package ru.asshands.softwire.tsykunovvkappclient.dagger

import dagger.Binds
import dagger.Module
import dagger.Reusable
import ru.asshands.softwire.tsykunovvkappclient.data.repository.PostRepositoryImpl
import ru.asshands.softwire.tsykunovvkappclient.data.repository.ProfileRepositoryImpl
import ru.asshands.softwire.tsykunovvkappclient.data.repository.SessionRepositoryImpl
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.PostRepository
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.ProfileRepository
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.SessionRepository

@Module(includes = [
    NetworkModule::class,
    ConverterModule::class
])
interface DataModule {

    @Reusable
    @Binds
    fun bindSessionRepository(instance: SessionRepositoryImpl): SessionRepository

    @Reusable
    @Binds
    fun bindPostRepository(instance: PostRepositoryImpl): PostRepository

    @Reusable
    @Binds
    fun bindProfileRepository(instance: ProfileRepositoryImpl): ProfileRepository

}