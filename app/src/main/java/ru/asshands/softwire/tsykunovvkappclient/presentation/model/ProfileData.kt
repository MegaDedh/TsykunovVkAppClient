package ru.asshands.softwire.tsykunovvkappclient.presentation.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class ProfileData(
    val id: Long,
    val phone: String,
    val firstName: String,
    val lastName: String,
    val avatar: String
)