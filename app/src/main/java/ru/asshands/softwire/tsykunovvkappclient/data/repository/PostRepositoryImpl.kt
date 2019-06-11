package ru.asshands.softwire.tsykunovvkappclient.data.repository

import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.asshands.softwire.tsykunovvkappclient.dagger.MockQualifier
import ru.asshands.softwire.tsykunovvkappclient.data.converter.BaseResponseTransformer
import ru.asshands.softwire.tsykunovvkappclient.data.converter.Converter
import ru.asshands.softwire.tsykunovvkappclient.data.network.Api
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.PostResponse
import ru.asshands.softwire.tsykunovvkappclient.domain.entity.Post
import ru.asshands.softwire.tsykunovvkappclient.domain.repository.PostRepository
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    @MockQualifier private val api: Api,
  //  private val api: Api,
    private val postsConverter: Converter<List<PostResponse>, List<Post>>
) : PostRepository {

    override fun getPosts(page: Int): Single<List<Post>> = api.getPosts(page)
        .subscribeOn(Schedulers.io())
  //      .compose(BaseResponseTransformer())
        .map(postsConverter::convert)


    override fun getPost(id: Long): Post {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


    /*    override fun getAll(): List<BaseMessage> = (1..100).map {
        if (it % 5 == 0) {
            CatMessage(
                it,
                "https://ichef.bbci.co.uk/images/ic/720x405/p0517py6.jpg"
            )
        } else {
            PostMessage(
                it,
                "Message".repeat(10),
              //  "https://picsum.photos/id/$it/200/300"
                "https://loremflickr.com/300/200/nature?random=$it"
            )
        }
    }*/


