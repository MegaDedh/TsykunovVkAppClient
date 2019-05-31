package ru.asshands.softwire.tsykunovvkappclient.dagger.module.data

import dagger.Binds
import dagger.Module
import ru.asshands.softwire.tsykunovvkappclient.data.converter.Converter
import ru.asshands.softwire.tsykunovvkappclient.data.converter.PostsConverter
import ru.asshands.softwire.tsykunovvkappclient.data.converter.ProfileConverter
import ru.asshands.softwire.tsykunovvkappclient.data.converter.UserConverter
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
    fun bindPostsConverter(instance: PostsConverter): Converter<List<PostResponse>, List<Post>>


    //?
    @Singleton
    @Binds
    fun bindProfileConverter(instance: ProfileConverter): Converter<User, ProfileData>
}