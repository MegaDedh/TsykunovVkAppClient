package ru.asshands.softwire.tsykunovvkappclient.domain.repository

import io.reactivex.Single
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User


interface ProfileRepository {

    fun getProfile(): Single<User>

}