package ru.asshands.softwire.tsykunovvkappclient.data.repository

import ru.asshands.softwire.tsykunovvkappclient.domain.repository.PostRepository
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.feed.BaseMessage
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.feed.CatMessage
import ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.feed.PostMessage
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor() : PostRepository {

    override fun getAll(): List<BaseMessage> = (1..100).map {
        if (it % 5 == 0) {
            CatMessage(
                it,
                "https://ichef.bbci.co.uk/images/ic/720x405/p0517py6.jpg"
            )
        } else {
            PostMessage(
                it,
                "Message".repeat(30),
                "https://picsum.photos/id/$it/200/300"
            )
        }
    }

    override fun getPost(id: Long): BaseMessage {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}