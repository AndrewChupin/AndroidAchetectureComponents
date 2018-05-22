package wizzard.bus.tutu.ru.posts.data.word.manager

import android.arch.persistence.room.*
import wizzard.bus.tutu.ru.posts.data.word.common.Word

@Dao
interface WordDao {

    @Insert
    fun insert(post: List<Word>)

    @Query("SELECT COUNT(*) FROM posts")
    fun count(): Int

    @Query("SELECT * FROM posts")
    fun findAll(): List<Word>

    @Update
    fun updateAll(post: List<Word>)

    @Query("DELETE FROM posts")
    fun deleteAll()

}
