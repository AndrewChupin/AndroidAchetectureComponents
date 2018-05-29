package wizzard.bus.tutu.ru.posts.data.word.repository

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import wizzard.bus.tutu.ru.posts.data.word.common.Word

@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(post: List<Word>)

    @Query("SELECT * FROM words")
    fun findAll(): List<Word>

    @Query("DELETE FROM words")
    fun deleteAll()

    @Query("SELECT COUNT(*) FROM words")
    fun count(): Int

    @Query("SELECT * FROM words")
    fun wordsPaging(): DataSource.Factory<Int, Word>

    @Query("SELECT * FROM words OFFSET :from LIMIT :size")
    fun wordsPagingRange(from: Int, size: Int): List<Word>

}
