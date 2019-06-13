package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.converter

import ru.asshands.softwire.tsykunovvkappclient.domain.entity.Post
import ru.asshands.softwire.tsykunovvkappclient.presentation.entity.PostMessage
import javax.inject.Inject

class PresentationPostConverter @Inject constructor() : PresentationConverter<Post, PostMessage> {

    override fun convert(t: Post): PostMessage =
        PostMessage(
            t.id,
            t.message,
            t.contentType,
            t.contentUrl,
            t.likes
        )
}