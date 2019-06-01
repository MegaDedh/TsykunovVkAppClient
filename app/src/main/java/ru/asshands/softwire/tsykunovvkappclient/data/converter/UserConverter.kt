package ru.asshands.softwire.tsykunovvkappclient.data.converter

import ru.asshands.softwire.tsykunovvkappclient.data.database.entity.UserEntity
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.UserResponse
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import javax.inject.Inject

class UserConverter @Inject constructor() : Converter<UserResponse, User> {

    override fun convert(t: UserResponse): User = User(
        t.id,
        t.phone,
        t.firstName,
        t.lastName,
        t.avatar
    )
}

class UserEntityConverter @Inject constructor() : Converter<UserEntity, User> {

    override fun convert(t: UserEntity): User = User(
        t.id,
        t.phone,
        t.firstName,
        t.lastName,
        t.avatar
    )
}