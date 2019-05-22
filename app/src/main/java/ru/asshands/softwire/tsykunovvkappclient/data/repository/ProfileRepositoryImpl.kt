package ru.asshands.softwire.tsykunovvkappclient.data.repository
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.ProfileRepository
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.ProfileData
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor() : ProfileRepository {

    override fun getProfile(): ProfileData {
        return ProfileData(
            firstName = "Alexey",
            surname = "Tsykunov",
            birthday = "21.05.1988",
            city = "Tomsk"
        )
    }
}