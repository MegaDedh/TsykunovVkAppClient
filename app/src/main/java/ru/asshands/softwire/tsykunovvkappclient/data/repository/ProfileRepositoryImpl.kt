
package ru.asshands.softwire.tsykunovvkappclient.data.repository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.asshands.softwire.tsykunovvkappclient.data.converter.Converter
import ru.asshands.softwire.tsykunovvkappclient.data.datasource.ProfileDataSource
import ru.asshands.softwire.tsykunovvkappclient.data.response.ProfileResponse
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.ProfileRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileDataSource: ProfileDataSource,
    private val userConverter: Converter<ProfileResponse, User>
) : ProfileRepository {

/*    companion object {
        private var firstName = "Alexey"
        private var surname = "Tsykunov"
        private var birthday = "21.05.1988"
        private var city = "Tomsk"
    }*/


    override fun getProfile(): Single<User> =
        profileDataSource.getProfile()
            .subscribeOn(Schedulers.io())
            .map(userConverter::convert)

/*    override fun setProfile(data: ProfileData): Int {
        firstName = data.firstName
        surname = data.surname
        birthday = data.birthday
        city = data.city
        return 0
    }*/
}
