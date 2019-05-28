package ru.asshands.softwire.tsykunovvkappclient.presentation.model

data class ProfileData (val id: Long,
                        val firstName: String,
                        val lastName: String,
                        val status: String,
                        val avatar: String,
                        val birthday: String,
                        val city: String,
                        val phone: String)