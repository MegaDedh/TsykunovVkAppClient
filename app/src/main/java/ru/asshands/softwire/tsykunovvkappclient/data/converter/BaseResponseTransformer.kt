package ru.asshands.softwire.tsykunovvkappclient.data.converter

import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import ru.asshands.softwire.tsykunovvkappclient.data.network.response.BaseResponse

class BaseResponseTransformer<T> : SingleTransformer<BaseResponse<T>, T> {

    override fun apply(upstream: Single<BaseResponse<T>>): SingleSource<T> = upstream.flatMap {
        when {
            it.data != null -> Single.just(it.data)
            it.error != null -> Single.error(RuntimeException(it.error.message))
            else -> Single.error(RuntimeException("Bad response"))
        }
    }
}