package ru.asshands.softwire.tsykunovvkappclient.data.database.dao

import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.OnConflictStrategy.REPLACE
import io.reactivex.Maybe
import ru.asshands.softwire.tsykunovvkappclient.data.database.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM users WHERE id=:id")
    fun getProfile(id: Long): Maybe<UserEntity>

    @Query("SELECT * FROM users WHERE phone=:phone")
    fun get(phone: String): Maybe<UserEntity>

    @Insert
    fun insert(user: UserEntity): Long

    @Update
    fun update(user: UserEntity): Int

    @Delete
    fun delete(user: UserEntity)

}