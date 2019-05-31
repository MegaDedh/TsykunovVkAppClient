package ru.asshands.softwire.tsykunovvkappclient.data.converter

import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import ru.asshands.softwire.tsykunovvkappclient.presentation.model.ProfileData
import javax.inject.Inject

class ProfileConverter @Inject constructor() : Converter<User, ProfileData> {

    override fun convert(t: User): ProfileData =
        ProfileData(
            t.id,
            t.phone,
            t.firstName,
            t.lastName,
            t.avatar
        )
}
