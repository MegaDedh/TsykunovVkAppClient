package ru.asshands.softwire.tsykunovvkappclient.data.network.response

import com.google.gson.annotations.SerializedName

class ErrorResponse(
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String
)