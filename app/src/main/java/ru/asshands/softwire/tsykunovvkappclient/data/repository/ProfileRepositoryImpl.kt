
package ru.asshands.softwire.tsykunovvkappclient.data.repository
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.asshands.softwire.tsykunovvkappclient.data.converter.Converter
import ru.asshands.softwire.tsykunovvkappclient.data.database.entity.UserEntity
import ru.asshands.softwire.tsykunovvkappclient.data.datasource.DbProfileDataSource
import ru.asshands.softwire.tsykunovvkappclient.data.datasource.ProfileDataSource
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.UserResponse
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.ProfileRepository
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileDataSource: ProfileDataSource,
    private val dbProfileDataSource: DbProfileDataSource,
    private val userConverter: Converter<UserResponse, User>,
    private val userEntityConverter: Converter<UserEntity, User>
) : ProfileRepository {


    override fun getProfileDb(id: Long): Single<User> = dbProfileDataSource
        .getProfile(id)
        .subscribeOn(Schedulers.io())
        .map(userEntityConverter::convert)


    override fun getProfile(): Single<User> = profileDataSource
        .getProfile()
        .subscribeOn(Schedulers.io())
        .map(userConverter::convert)

}
