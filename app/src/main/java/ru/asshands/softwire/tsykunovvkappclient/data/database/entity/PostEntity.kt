package ru.asshands.softwire.tsykunovvkappclient.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "post", primaryKeys = ["id"])
data class PostEntity(

    @ColumnInfo(name = "id") val id: Long,
    @ColumnInfo(name = "message") val message: String,
    @ColumnInfo(name = "contentType") val contentType: String,
    @ColumnInfo(name = "contentUrl") val contentUrl: String,
    @ColumnInfo(name = "likes") val likes: Int

)