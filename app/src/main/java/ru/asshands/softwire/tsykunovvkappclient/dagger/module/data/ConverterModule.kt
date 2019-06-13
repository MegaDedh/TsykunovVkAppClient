package ru.asshands.softwire.tsykunovvkappclient.dagger.module.data

import dagger.Binds
import dagger.Module
import ru.asshands.softwire.tsykunovvkappclient.data.converter.*
import ru.asshands.softwire.tsykunovvkappclient.data.database.entity.UserEntity
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.PostResponse
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.UserResponse
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.Post
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import ru.asshands.softwire.tsykunovvkappclient.presentation.entity.PostMessage
import ru.asshands.softwire.tsykunovvkappclient.presentation.entity.ProfileMessage
import ru.asshands.softwire.tsykunovvkappclient.presentation.model.ProfileData
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.converter.PresentationPostConverter
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.converter.PresentationConverter
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.converter.PresentationProfileConverter
import javax.inject.Singleton

@Module
interface ConverterModule {

    @Singleton
    @Binds
    fun bindUserConverter(instance: UserConverter):
            Converter<UserResponse, User>

    @Singleton
    @Binds
    fun bindUserEntityConverter(instance: UserEntityConverter):
            Converter<UserEntity, User>

    @Singleton
    @Binds
    fun bindPostsConverter(instance: PostsConverter):
            Converter<List<PostResponse>, List<Post>>

    @Singleton
    @Binds
    fun bindPresentationPostConverter(instance: PresentationPostConverter):
            PresentationConverter<Post, PostMessage>

    @Singleton
    @Binds
    fun bindPresentationProfileConverter(instance: PresentationProfileConverter):
            PresentationConverter<User, ProfileMessage>

    //?
    @Singleton
    @Binds
    fun bindProfileConverter(instance: ProfileConverter):
            Converter<User, ProfileData>
}