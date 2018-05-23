package wizzard.bus.tutu.ru.posts.domain.interactor.posts

import com.testtask.santa.core.data.Result
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import wizzard.bus.tutu.ru.posts.data.word.common.Word
import wizzard.bus.tutu.ru.posts.data.word.repository.WordRepository
import wizzard.bus.tutu.ru.posts.data.word.service.WordService
import wizzard.bus.tutu.ru.posts.utils.mapAll
import javax.inject.Inject


class WordsInteractorDefault @Inject constructor(
        private val wordRepository: WordRepository,
        private val wordService: WordService
): WordsInteractor {

    override suspend fun loadWords(): Deferred<List<Word>> = async {
        val wordsDef = wordService.loadWords()
        val words = wordsDef.await()
        when(words) {
            is Result.Success -> words.data.mapAll()
            else -> emptyList()
        }
    }


}
