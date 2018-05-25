package wizzard.bus.tutu.ru.posts.domain.interactor.posts

import android.arch.paging.DataSource
import com.testtask.santa.core.utils.mapAll
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

    override suspend fun getWords(): List<Word> = async {
        val deferred = wordService.loadWords()
        val words = deferred.await()
            .handleDefault()
            .mapAll()
        wordRepository.insertAll(words)

        words
    }.await() // TODO Maybe deferred???


    override suspend fun getWordsPaging(): DataSource.Factory<Int, Word> = async {
        wordRepository.wordsPaging()
    }.await() // TODO Maybe deferred???
}

