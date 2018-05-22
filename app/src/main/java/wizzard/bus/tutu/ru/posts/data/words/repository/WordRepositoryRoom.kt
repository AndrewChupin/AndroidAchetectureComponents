package wizzard.bus.tutu.ru.posts.data.words.repository

import wizzard.bus.tutu.ru.posts.app.AppDatabase
import wizzard.bus.tutu.ru.posts.data.words.entity.Word
import javax.inject.Inject

class WordRepositoryRoom @Inject constructor(
        appDatabase: AppDatabase
): WordRepository {

    override fun insertAll(entities: List<Word>) {
    }

    override fun deleteAll() {
    }

    override fun findAll(): List<Word> {
        return emptyList<Word>()
    }

    override fun count(): Int {
        return 1
    }

}