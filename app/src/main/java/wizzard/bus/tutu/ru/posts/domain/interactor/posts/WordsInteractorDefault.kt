package wizzard.bus.tutu.ru.posts.domain.interactor.posts

import com.testtask.santa.core.data.service.ResponseResult
import com.testtask.santa.core.utils.mapAll
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import wizzard.bus.tutu.ru.posts.data.settings.SettingsRepository
import wizzard.bus.tutu.ru.posts.data.word.common.Word
import wizzard.bus.tutu.ru.posts.data.word.repository.WordRepository
import wizzard.bus.tutu.ru.posts.data.word.service.WordService
import javax.inject.Inject


class WordsInteractorDefault @Inject constructor(
        private val wordRepository: WordRepository,
        private val settingsRepository: SettingsRepository,
        private val wordService: WordService
): WordsInteractor {

    override suspend fun getWords(onSuccess: (List<Word>) -> Unit, onError: (Throwable) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun loadWords(): Deferred<List<Word>> = async {
        val wordsDef = wordService.loadWords()
        val words = wordsDef.await()
        when (words) {
            is ResponseResult.Success -> {
                val wordsDom = words.data.mapAll()
                wordsDom
            }
            is ResponseResult.Error -> {
                throw IllegalArgumentException("Error with code ${words.code}")
            }
            is ResponseResult.Exception -> {
                throw words.error
            }
        }
    }

    override suspend fun getWords(): List<Word> {
        val deferred = async {
            val deferred = wordService.loadWords()
            deferred.await().handleDefault().mapAll()
        }
        return deferred.await()
    }
}

