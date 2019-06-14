package ru.asshands.softwire.tsykunovvkappclient.data.storage

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.Post
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.User
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.PostRoomRepository
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.UserRepository
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

interface StorageInflate{
    fun addMainUser(){}
    fun addPost(id: Long, message: String, contentType: String, contentUrl: String){}
}

class StorageInflateImpl @Inject constructor(
    private val userRepository: UserRepository,
    private val postRoomRepository: PostRoomRepository
): StorageInflate {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun addPost(id: Long, message: String, contentType: String, contentUrl: String) {
        postRoomRepository.create(
            Post(
                id,
                message,
                contentType,
                contentUrl,
                likes = (0..100).random()
            )
        )
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Timber.d("DbPost was created!")
                },
                {
                    Timber.e(it.message.orEmpty())
                }
            )
            .untilDestroy()
    }


    override fun addMainUser() {
        userRepository.create(
            User(
                id = 100200300,
                phone = "555",
                firstName = "Алексей",
                lastName = "Цыкунов",
                birthday = "21.05.1988",
                city = "Томск",
                avatar = "https://pp.userapi.com/c850016/v850016044/1a25fc/cHZ5EmlnW5o.jpg"
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