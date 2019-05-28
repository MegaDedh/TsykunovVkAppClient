package ru.asshands.softwire.tsykunovvkappclient.data.response

import com.google.gson.annotations.SerializedName

class ProfileResponse(
    @SerializedName("id") val id: Long,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String,
    @SerializedName("status") val status: String,
    @SerializedName("avatar") val avatar: String,
    @SerializedName("birthday") val birthday: String,
    @SerializedName("city") val city: String,
    @SerializedName("phone") val phone: String


)