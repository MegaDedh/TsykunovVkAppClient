package ru.asshands.softwire.tsykunovvkappclient.data.network.response

import com.google.gson.annotations.SerializedName

class LoginResponse(
    @SerializedName("token") val token: String
)