package wizzard.bus.tutu.ru.posts.data.word.repository

import wizzard.bus.tutu.ru.posts.app.AppDatabase
import wizzard.bus.tutu.ru.posts.data.word.common.Word
import javax.inject.Inject

class WordRepositoryRoom @Inject constructor(
    private val appDatabase: AppDatabase
): WordRepository {

    override fun insertAll(entities: List<Word>) {
        appDatabase.postsDao().insertAll(entities)
    }

    override fun deleteAll() {
        appDatabase.postsDao().deleteAll()
    }

    override fun findAll(): List<Word> = appDatabase.postsDao().findAll()

    override fun count(): Int = appDatabase.postsDao().count()

}
