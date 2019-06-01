package ru.asshands.softwire.tsykunovvkappclient.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.asshands.softwire.tsykunovvkappclient.data.database.dao.UserDao
import ru.asshands.softwire.tsykunovvkappclient.data.database.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {
        fun create(context: Context, inMemory: Boolean): AppDatabase = if (inMemory) {
            Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        } else {
            Room.databaseBuilder(context, AppDatabase::class.java, "AppDatabase.db").build()
        }
    }

}