package ru.asshands.softwire.tsykunovvkappclient.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import java.util.*

@Entity(tableName = "users", primaryKeys = ["id", "phone"])
data class UserEntity(

    @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "phone") val phone: String,
    @ColumnInfo(name = "password") val password: String,
    @ColumnInfo(name = "first_name") val firstName: String,
    @ColumnInfo(name = "last_name") val lastName: String,
    @ColumnInfo(name = "birthday") val birthday: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "avatar") val avatar: String

)