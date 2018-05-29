package wizzard.bus.tutu.ru.posts.domain.interactor.posts

import wizzard.bus.tutu.ru.posts.data.word.common.Word

interface WordsInteractor {
    suspend fun getWords(): List<Word>
    suspend fun getWordsRange(from: Int, size: Int): List<Word>
}
