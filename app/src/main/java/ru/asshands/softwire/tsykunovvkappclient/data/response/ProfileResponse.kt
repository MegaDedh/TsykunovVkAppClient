package ru.asshands.softwire.tsykunovvkappclient.data.response

import com.google.gson.annotations.SerializedName

class ProfileResponse(
    @SerializedName("id") var id: Long,
    @SerializedName("firstName") var firstName: String,
    @SerializedName("lastName") var lastName: String
)