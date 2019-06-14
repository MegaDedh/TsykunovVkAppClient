package ru.asshands.softwire.tsykunovvkappclient.data.database.dao

import androidx.room.*
import io.reactivex.Maybe
import ru.asshands.softwire.tsykunovvkappclient.data.database.entity.PostEntity

@Dao
interface PostDao {

    @Query("SELECT * FROM post WHERE id=:page")
    fun getPosts(page: Int): Maybe<PostEntity>

    @Query("SELECT * FROM post WHERE id=:id")
    fun get(id: Long): Maybe<PostEntity>

    @Insert
    fun insert(post: PostEntity): Long

    @Update
    fun update(post: PostEntity): Int

    @Delete
    fun delete(post: PostEntity)

}