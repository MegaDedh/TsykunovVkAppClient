package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.converter

import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import ru.asshands.softwire.tsykunovvkappclient.presentation.entity.ProfileMessage

class ProfileConverter: Converter <User, ProfileMessage> {
    override fun convert(t: User): ProfileMessage =
        ProfileMessage(
        t.id,
        t.phone,
        t.firstName,
        t.lastName,
        t.birthday,
        t.city,
        t.avatar)

    }