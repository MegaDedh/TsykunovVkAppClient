package ru.asshands.softwire.tsykunovvkappclient.data.network.response

import com.google.gson.annotations.SerializedName

class PostResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("message") val message: String,
    @SerializedName("contentType") val contentType: String,
    @SerializedName("contentUrl") val contentUrl: String,
    @SerializedName("likes") val likes: Int
)