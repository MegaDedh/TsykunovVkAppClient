package ru.asshands.softwire.tsykunovvkappclient.data.database.dao

import androidx.room.*
import io.reactivex.Maybe
import ru.asshands.softwire.tsykunovvkappclient.data.database.entity.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM users WHERE phone=:phone")
    fun get(phone: String): Maybe<UserEntity>

    @Insert
    fun insert(user: UserEntity): Long

    @Update
    fun update(user: UserEntity)

    @Delete
    fun delete(user: UserEntity)

}