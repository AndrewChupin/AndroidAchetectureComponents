package wizzard.bus.tutu.ru.posts.data.word.manager

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import wizzard.bus.tutu.ru.posts.data.word.common.Word

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(post: List<Word>)

    @Query("SELECT * FROM posts")
    fun findAll(): List<Word>

    @Query("DELETE FROM posts")
    fun deleteAll()

    @Query("SELECT COUNT(*) FROM posts")
    fun count(): Int

}
