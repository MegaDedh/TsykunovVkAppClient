package ru.asshands.softwire.tsykunovvkappclient.dagger.module.data

import dagger.Binds
import dagger.Module
import dagger.Reusable
import ru.asshands.softwire.tsykunovvkappclient.data.converter.Converter
import ru.asshands.softwire.tsykunovvkappclient.data.converter.PostsConverter
import ru.asshands.softwire.tsykunovvkappclient.data.converter.ProfileConverter
import ru.asshands.softwire.tsykunovvkappclient.data.converter.UserConverter
import ru.asshands.softwire.tsykunovvkappclient.data.response.PostResponse
import ru.asshands.softwire.tsykunovvkappclient.data.response.ProfileResponse
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.Post
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import ru.asshands.softwire.tsykunovvkappclient.presentation.model.ProfileData

@Module
interface ConverterModule {

    @Reusable
    @Binds
    fun bindUserConverter(instance: UserConverter): Converter<ProfileResponse, User>

    @Reusable
    @Binds
    fun bindPostsConverter(instance: PostsConverter): Converter<List<PostResponse>, List<Post>>

    @Reusable
    @Binds
    fun bindProfileConverter(instance: ProfileConverter): Converter<User, ProfileData>
}