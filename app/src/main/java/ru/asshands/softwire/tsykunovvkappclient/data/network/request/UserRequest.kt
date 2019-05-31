package ru.asshands.softwire.tsykunovvkappclient.data.network.request

import com.google.gson.annotations.SerializedName

class UserRequest(
    @SerializedName("phone") val phone: String,
    @SerializedName("password") val password: String
)