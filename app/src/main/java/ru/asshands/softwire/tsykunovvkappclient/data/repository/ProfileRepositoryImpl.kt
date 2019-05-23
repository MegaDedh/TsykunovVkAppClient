package ru.asshands.softwire.tsykunovvkappclient.data.repository
import android.util.Log
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.ProfileRepository
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.ProfileData
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor() : ProfileRepository {

    companion object {
        private var firstName = "Alexey"
        private var surname = "Tsykunov"
        private var birthday = "21.05.1988"
        private var city = "Tomsk"
    }


    override fun getProfile(): ProfileData {
        return ProfileData(
            firstName,
            surname,
            birthday,
            city)
    }

    override fun setProfile(data: ProfileData): Int {
        firstName = data.firstName
        surname = data.surname
        birthday = data.birthday
        city = data.city
        return 0
    }
}