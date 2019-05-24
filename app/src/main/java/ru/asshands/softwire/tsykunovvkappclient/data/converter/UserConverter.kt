package ru.asshands.softwire.tsykunovvkappclient.data.converter

import ru.asshands.softwire.tsykunovvkappclient.data.response.ProfileResponse
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import javax.inject.Inject

class UserConverter @Inject constructor() : Converter<ProfileResponse, User> {

    override fun convertTo(t: ProfileResponse): User = User(
        t.id,
        t.firstName,
        t.lastName
    )

    override fun convertFrom(k: User): ProfileResponse = ProfileResponse(
        k.id,
        k.firstName,
        k.lastName
    )
}