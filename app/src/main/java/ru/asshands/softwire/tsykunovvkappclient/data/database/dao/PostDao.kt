package ru.asshands.softwire.tsykunovvkappclient.data.database.dao

import androidx.room.*
import io.reactivex.Maybe
import ru.asshands.softwire.tsykunovvkappclient.data.database.entity.PostEntity

@Dao
interface PostDao {

    //SELECT * FROM TABLE WHERE id = (SELECT MAX(id) FROM TABLE);

    @Query("SELECT * FROM post WHERE id<=:page*20 AND id>:page*20-20")
    fun getPosts(page: Int): Maybe<List<PostEntity>>

    @Query("SELECT * FROM post WHERE id=:id")
    fun get(id: Long): Maybe<PostEntity>

    @Query("SELECT * FROM post")
    fun getAllPosts(): Maybe<List<PostEntity>>

    @Insert
    fun insert(post: PostEntity): Long

    @Update
    fun update(post: PostEntity): Int

    @Delete
    fun delete(post: PostEntity)

}