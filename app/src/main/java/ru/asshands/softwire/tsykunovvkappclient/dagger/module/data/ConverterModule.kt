package ru.asshands.softwire.tsykunovvkappclient.dagger.module.data

import dagger.Binds
import dagger.Module
import ru.asshands.softwire.tsykunovvkappclient.data.converter.*
import ru.asshands.softwire.tsykunovvkappclient.data.database.entity.UserEntity
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.PostResponse
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.UserResponse
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.Post
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import ru.asshands.softwire.tsykunovvkappclient.presentation.model.ProfileData
import javax.inject.Singleton

@Module
interface ConverterModule {

    @Singleton
    @Binds
    fun bindUserConverter(instance: UserConverter): Converter<UserResponse, User>

    @Singleton
    @Binds
    fun bindUserEntityConverter(instance: UserEntityConverter): Converter<UserEntity, User>

    @Singleton
    @Binds
    fun bindPostsConverter(instance: PostsConverter): Converter<List<PostResponse>, List<Post>>


    //?
    @Singleton
    @Binds
    fun bindProfileConverter(instance: ProfileConverter): Converter<User, ProfileData>
}