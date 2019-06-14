package ru.asshands.softwire.tsykunovvkappclient.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.asshands.softwire.tsykunovvkappclient.data.database.dao.PostDao
import ru.asshands.softwire.tsykunovvkappclient.data.database.dao.UserDao
import ru.asshands.softwire.tsykunovvkappclient.data.database.entity.PostEntity
import ru.asshands.softwire.tsykunovvkappclient.data.database.entity.UserEntity

@Database(entities = [UserEntity::class, PostEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao
    abstract fun getPostDao(): PostDao

    companion object {
        fun create(context: Context, inMemory: Boolean): AppDatabase = if (inMemory) {
            Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        } else {
            Room.databaseBuilder(context, AppDatabase::class.java, "AppDatabase.db").build()
        }
    }

}