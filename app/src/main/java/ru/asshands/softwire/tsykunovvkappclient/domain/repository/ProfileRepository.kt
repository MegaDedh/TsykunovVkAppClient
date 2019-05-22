package ru.asshands.softwire.tsykunovvkappclient.domain.repository

import ru.asshands.softwire.tsykunovvkappclient.presentation.common.ProfileData


interface ProfileRepository {

    fun getProfile(): ProfileData
    fun setProfile(data: ProfileData): Int

}