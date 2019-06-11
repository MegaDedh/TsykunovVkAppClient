package ru.asshands.softwire.tsykunovvkappclient.data.storage

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.UserRepository
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

interface StorageInflate{
    fun addMainUser(){}
}

class StorageInflateImpl @Inject constructor(
    private val userRepository: UserRepository
): StorageInflate {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun addMainUser() {
        userRepository.create(
            User(
                id = 100200300,
                phone = "555",
                firstName = "dbUserName",
                lastName = "dbUserLastName",
                birthday = "21.05.1988",
                city = "dbCity",
                avatar = "avatark.jpg"
            ), "root"
        )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.d("DbUser was created!")
                },
                {
                    Timber.e(it.message.orEmpty())
                }
            )
            .untilDestroy()
    }

    private fun Disposable.untilDestroy() {
        compositeDisposable.add(this)
    }
}