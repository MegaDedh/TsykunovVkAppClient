package ru.asshands.softwire.tsykunovvkappclient.data.repository
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.ProfileRepository
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.ProfileData

import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor() : ProfileRepository {

        override fun getProfile(): ProfileData {
            val data = ProfileData()
            // TODO сделать класс с данными профиля
            return data
        }
    }