package ru.asshands.softwire.tsykunovvkappclient.dagger.module.data

import dagger.Binds
import dagger.Module
import dagger.Reusable
import ru.asshands.softwire.tsykunovvkappclient.data.converter.Converter
import ru.asshands.softwire.tsykunovvkappclient.data.converter.UserConverter
import ru.asshands.softwire.tsykunovvkappclient.data.response.ProfileResponse
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User

@Module
interface ConverterModule {

    @Reusable
    @Binds
    fun bindUserConverter(instance: UserConverter): Converter<ProfileResponse, User>

    @Reusable
    @Binds
    fun bindPostsConverter(instance: UserConverter): Converter<ProfileResponse, User>

}