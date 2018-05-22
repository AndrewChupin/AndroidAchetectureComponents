package wizzard.bus.tutu.ru.posts.domain.interactor.posts

import com.testtask.santa.core.data.mapper.BaseMapper
import wizzard.bus.tutu.ru.posts.data.word.common.Word
import wizzard.bus.tutu.ru.posts.data.word.common.WordDto
import wizzard.bus.tutu.ru.posts.data.word.common.WordDtoToDomain
import wizzard.bus.tutu.ru.posts.data.word.repository.WordRepository
import wizzard.bus.tutu.ru.posts.data.word.service.WordService
import javax.inject.Inject


class WordsInteractorDefault @Inject constructor(
        val wordRepository: WordRepository,
        val wordService: WordService,
        val mapper: WordDtoToDomain
): WordsInteractor {

    override suspend fun loadWords(): List<Word> {
        val wordsDef = wordService.loadWords()
        return mapper.map(wordsDef.await())
    }

}
