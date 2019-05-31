package ru.asshands.softwire.tsykunovvkappclient.data.network.response

import com.google.gson.annotations.SerializedName

class BaseResponse<T>(
    @SerializedName("data") val data: T?,
    @SerializedName("error") val error: ErrorResponse?
)