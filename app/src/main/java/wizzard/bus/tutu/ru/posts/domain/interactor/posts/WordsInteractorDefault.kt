package wizzard.bus.tutu.ru.posts.domain.interactor.posts

import com.testtask.santa.core.data.service.Result
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

    override suspend fun loadWords(): Deferred<List<Word>> = async {
        //if (wordRepository.count() > 0) wordRepository.findAll()
        val wordsDef = wordService.loadWords()
        val words = wordsDef.await()
        val worldsToken = settingsRepository.wordsStateToken
        when(words) {
            is Result.Success -> {
                val wordsDom = words.data.mapAll()
                // wordRepository.insertAll(wordsDom)
                // wordRepository.findAll()
                wordsDom
            }
            is Result.Error -> {
                throw IllegalArgumentException("Error with code ${words.code}")
            }
            is Result.Exception -> {
                throw words.error
            }
        }
    }

}
