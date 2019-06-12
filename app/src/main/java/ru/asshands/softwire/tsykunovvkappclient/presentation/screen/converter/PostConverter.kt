package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.converter

import ru.asshands.softwire.tsykunovvkappclient.domain.entity.Post
import ru.asshands.softwire.tsykunovvkappclient.presentation.entity.PostMessage

class PostConverter: Converter<Post, PostMessage> {

    override fun convert(t: Post): PostMessage =
        PostMessage(
            t.id,
            t.message,
        "imageURL"
        )
}