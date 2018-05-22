package wizzard.bus.tutu.ru.posts.domain.interactor.posts

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import wizzard.bus.tutu.ru.posts.data.words.entity.Word
import wizzard.bus.tutu.ru.posts.data.words.repository.WordRepository
import javax.inject.Inject


class WordsInteractorDefault @Inject constructor(
        val wordRepository: WordRepository
): WordsInteractor {

    override fun loadWords(): Deferred<List<Word>> = async(CommonPool) {
        List(100) {
            Word(it.toLong(), "word $it")
        }
    }

    override fun refreshWords(): Deferred<List<Word>> = async(CommonPool) {
        emptyList<Word>()
    }

}
