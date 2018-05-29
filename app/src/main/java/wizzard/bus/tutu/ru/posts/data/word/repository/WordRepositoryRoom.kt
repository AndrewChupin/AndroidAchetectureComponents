package wizzard.bus.tutu.ru.posts.data.word.repository

import android.arch.paging.DataSource
import wizzard.bus.tutu.ru.posts.app.AppDatabase
import wizzard.bus.tutu.ru.posts.data.word.common.Word
import javax.inject.Inject

class WordRepositoryRoom @Inject constructor(
    private val appDatabase: AppDatabase
): WordRepository {

    override fun wordsPaging(): DataSource.Factory<Int, Word> = appDatabase.postsDao().wordsPaging()

    override fun insertAll(entities: List<Word>) {
        appDatabase.postsDao().insertAll(entities)
    }

    override fun deleteAll() {
        appDatabase.postsDao().deleteAll()
    }

    override fun wordsRange(from: Int, size: Int): List<Word> {
        return appDatabase.postsDao().wordsPagingRange(from, size)
    }

    override fun findAll(): List<Word> = appDatabase.postsDao().findAll()

    override fun count(): Int = appDatabase.postsDao().count()

}
