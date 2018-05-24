package wizzard.bus.tutu.ru.posts.domain.interactor.posts

import kotlinx.coroutines.experimental.Deferred
import wizzard.bus.tutu.ru.posts.data.word.common.Word

interface WordsInteractor {
    suspend fun loadWords(): Deferred<List<Word>>
    suspend fun getWords(): List<Word>
    suspend fun getWords(onSuccess: (List<Word>) -> Unit, onError: (Throwable) -> Unit = {})
}
